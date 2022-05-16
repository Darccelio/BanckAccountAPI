package com.darccelio.banckAccount.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "account")
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_account", nullable = false)
  private Long id;

  @NotEmpty
  @Pattern(regexp = "^[0,9]{1,4}[-]?[0,9]{0,2}", message = "Please, insert agency number correctly")
  @Column(name = "number_account", nullable = false)
  private Integer number;

  @NotEmpty
  @Pattern(
      regexp = "^[0,9]{1,3}[-][0,9]{0,2}",
      message = "Please, insert agency number correctly")
  @Column(name = "agency", nullable = false)
  private Integer agency;

  @NotEmpty
  @Pattern(regexp = "^\\$?([0-9]{1,3},([0-9]{3},)*[0-9]{3}|[0-9]+)(.[0-9][0-9])?$")
  @Column(name = "account_balance")
  private BigDecimal balance;

  @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
  @NotEmpty
  @ManyToMany
  private Set<Cliente> cliente;

}
