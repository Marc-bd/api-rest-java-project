package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.doctor.DoctorRepository;
import med.voll.api.doctor.DoctorSchema;
import med.voll.api.doctor.dto.CreateDoctorDTO;
import med.voll.api.doctor.dto.ListDoctorDTO;
import med.voll.api.doctor.dto.UpdateDoctorDTO;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

  @Autowired
  private DoctorRepository repository;

  @PostMapping
  @Transactional // do spring -> para fazer a transação ativa com db
  public void register(@RequestBody @Valid CreateDoctorDTO data) {
    repository.save(new DoctorSchema(data));
  }

  @GetMapping
  public Page<ListDoctorDTO> list(@PageableDefault(size = 10, sort = { "name" }) Pageable pagination) {
    return repository.findAllByIsActiveTrue(pagination).map(ListDoctorDTO::new);
  }

  @PutMapping
  @Transactional
  public void update(@RequestBody @Valid UpdateDoctorDTO data) {
    var doctor = repository.getReferenceById(data.id());
    doctor.updateData(data);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public void delete(@PathVariable Long id) {
    var doctor = repository.getReferenceById(id);

    doctor.disable();
  }

  @PostMapping("/active/{id}")
  @Transactional
  public void active(@PathVariable Long id) {
    var doctor = repository.getReferenceById(id);

    doctor.active();
  }

}
