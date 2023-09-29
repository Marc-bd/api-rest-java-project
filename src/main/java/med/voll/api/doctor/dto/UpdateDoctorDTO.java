package med.voll.api.doctor.dto;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressDTO;
import med.voll.api.doctor.enums.Specialty;

public record UpdateDoctorDTO(@NotNull Long id, String name, String phone, String email, AddressDTO Address,
    Specialty specialty) {

}
