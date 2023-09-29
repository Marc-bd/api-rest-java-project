package med.voll.api.patient.dtos;

import med.voll.api.address.AddressSchema;
import med.voll.api.patient.PatientSchema;

public record ListPatientDTO(Long id, String name, String phone, String email, boolean healthInsurance,
    AddressSchema address) {

  public ListPatientDTO(PatientSchema patient) {
    this(patient.getId(), patient.getName(), patient.getPhone(), patient.getEmail(), patient.getHealthInsurance(),
        patient.getAddress());
  }

}
