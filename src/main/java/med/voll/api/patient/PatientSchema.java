package med.voll.api.patient;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.address.AddressSchema;

/*
 * Onde está o schema do paciente, possui o construtor para instanciar o objeto e as propriedades do lamboke jakarta para validação dos campos recebidos;
 */

// nome da tabela
@Table(name = "patient")

// nome da entidade
@Entity(name = "Patient")

// implementa metodos getters para classe
@Getter

// Gera automaticamente constructor sem precisar passar todos os dados
@NoArgsConstructor

// Gera um constructor que precisa passar todos os dados
@AllArgsConstructor

// gera automaticamente metodo Equals e hashCode considerando o campo id do
// paciente
@EqualsAndHashCode(of = "id")
public class PatientSchema {

  /*
   * Geração de ID e como ele deve ser gerado;
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String email;
  private String phone;
  private Boolean healthInsurance;

  // para indiciar que a classe possui relação com outra classe
  @Embedded
  private AddressSchema address;

  public PatientSchema(PatientDTO data) {
    this.name = data.name();
    this.email = data.email();
    this.phone = data.phone();
    this.healthInsurance = data.healthInsurance();
    this.address = new AddressSchema(data.address());
  }

}
