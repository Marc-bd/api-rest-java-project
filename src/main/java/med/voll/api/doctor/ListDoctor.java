package med.voll.api.doctor;

public record ListDoctor(String name, String email, String crm, Specialty especialty) {

  public ListDoctor(DoctorSchema doctor) {
    this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getEspecialty());
  }

}
