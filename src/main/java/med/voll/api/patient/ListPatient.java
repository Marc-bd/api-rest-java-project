package med.voll.api.patient;

import med.voll.api.address.AddressSchema;

public record ListPatient(String name, String phone, String email, boolean healthInsurance, AddressSchema address) {

  public ListPatient(PatientSchema patient) {
    this(patient.getName(), patient.getPhone(), patient.getEmail(), patient.getHealthInsurance(), patient.getAddress());
  }

}
