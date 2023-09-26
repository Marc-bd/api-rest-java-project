package med.voll.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import med.voll.api.doctor.DoctorSchema;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

  @PostMapping
  public void register(@RequestBody DoctorSchema json) {
    System.out.println(json);
  }

}
