package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.doctor.DoctorDTO;

import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.DoctorSchema;
import med.voll.api.doctor.ListDoctor;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

  @Autowired
  private DoctorRepository repository;

  @PostMapping
  @Transactional // do spring -> para fazer a transação ativa com db
  public void register(@RequestBody @Valid DoctorDTO data) {
    repository.save(new DoctorSchema(data));
  }

  @GetMapping
  public Page<ListDoctor> list(@PageableDefault(size = 10, sort = { "name" }) Pageable pagination) {
    return repository.findAll(pagination).map(ListDoctor::new);
  }

}
