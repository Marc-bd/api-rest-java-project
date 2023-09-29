package med.voll.api.doctor.dto;

import med.voll.api.doctor.DoctorSchema;
import med.voll.api.doctor.enums.Specialty;

public record ListDoctorDTO(Long id, String name, String email, String crm, Specialty especialty) {

  public ListDoctorDTO(DoctorSchema doctor) {
    this(doctor.getId(), doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getSpecialty());
  }

}
