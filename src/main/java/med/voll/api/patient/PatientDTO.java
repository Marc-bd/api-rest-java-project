package med.voll.api.patient;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import med.voll.api.address.AddressDTO;

/*  Declaração de um DTO (Data Transfer Object) chamado PatientDTO
 * Utilizado para receber dados de um paciente, e ele contém anotações de validação do Jakarta Validation para garantir que os dados recebidos estejam de acordo com as expectativas
 * 
 * Após a verificação dos campos no PatientDTO, você pode usá-lo para criar uma instância de PatientSchema (que parece ser uma entidade JPA representando um paciente no banco de dados). Isso é feito no construtor de PatientSchema que aceita um PatientDTO como argumento
 */
public record PatientDTO(
        // Campo 'name' - Não pode ser vazio ou nulo
        @NotBlank String name,

        // Campo 'email' - Deve ser um endereço de e-mail válido, e não pode ser vazio
        // ou nulo
        @NotBlank @Email String email,

        // Campo 'phone' - Não pode ser vazio ou nulo
        @NotBlank String phone,

        // Campo 'healthInsurance' - Não pode ser nulo, deve ser um valor booleano (true
        // ou false)
        @NotNull Boolean healthInsurance,

        // Campo 'address' - Não pode ser nulo e deve ser um objeto AddressDTO válido
        @NotNull @Valid AddressDTO address) {

}
