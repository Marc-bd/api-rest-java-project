package med.voll.api.doctor;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import med.voll.api.address.AddressSchema;
import med.voll.api.doctor.dto.CreateDoctorDTO;
import med.voll.api.doctor.dto.UpdateDoctorDTO;
import med.voll.api.doctor.enums.Specialty;

@Table(name = "doctor")
@Entity(name = "Doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class DoctorSchema {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)

  private Long id;
  private String name;
  private String email;
  private String phone;
  private String crm;
  private Boolean isActive;

  @Enumerated(EnumType.STRING)
  private Specialty specialty;

  @Embedded
  private AddressSchema address;

  public DoctorSchema(@Valid CreateDoctorDTO data) {
    this.name = data.name();
    this.email = data.email();
    this.phone = data.phone();
    this.crm = data.crm();
    this.specialty = data.specialty();
    this.address = new AddressSchema(data.address());
    this.isActive = true;
  }

  public void updateData(UpdateDoctorDTO data) {

    if (data.name() != null) {
      this.name = data.name();
    }

    if (data.phone() != null) {
      this.phone = data.phone();
    }

    if (data.email() != null) {
      this.email = data.email();
    }

    if (data.specialty() != null) {
      this.specialty = data.specialty();
    }

    if (data.Address() != null) {
      this.address.update(data.Address());
    }
  }

  public void disable() {
    this.isActive = false;
  }

  public void active() {
    this.isActive = true;
  }
}
