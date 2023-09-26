package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.patient.ListPatient;
import med.voll.api.patient.PatientDTO;
import med.voll.api.patient.PatientRepository;
import med.voll.api.patient.PatientSchema;

// Indica que esta classe é um controlador REST, o que significa que ela será responsável por lidar com requisições HTTP e retornar respostas HTTP.
@RestController

// Define o mapeamento da rota para este controlador, todas as requisições
// feitas para "/patient" serão tratadas por este controlador
@RequestMapping("/patient")
public class PatientController {

  // Injeta a instância de PatientRepository no Controller, permitindo que o
  // controlador utilize os métodos fornecidos pelo repositório para interagir
  // com o banco de dados.
  @Autowired
  private PatientRepository repository;

  // Método para lidar com requisições POST para a rota "/patient"
  @PostMapping

  // Indica que este método envolve uma transação, ou seja, operações no banco
  // de dados serão tratadas de forma transacional, ou seja, serão completas e
  // bem-sucedidas como um conjunto ou nenhuma delas será realizada.
  @Transactional
  public void register(@RequestBody @Valid PatientDTO data) {

    // Cria uma nova instância de PatientSchema a partir dos dados fornecidos
    PatientSchema newPatient = new PatientSchema(data);

    // Salva a nova instância no banco de dados usando o repositório
    repository.save(newPatient);
  }

  @GetMapping
  public Page<ListPatient> list(@PageableDefault(size = 10, sort = { "name" }) Pageable pageable) {

    return repository.findAll(pageable).map(ListPatient::new);
  }

}
