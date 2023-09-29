package med.voll.api.patient.dtos;

import jakarta.validation.constraints.NotNull;
import med.voll.api.address.AddressDTO;

public record UpdatePatientDTO(@NotNull Long id, String name, String email, String phone, Boolean healthInsurance,
    AddressDTO address) {

}
