package med.voll.api.address;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddressSchema {
  private String street;
  private String neighborhood;
  private String zipCode;
  private String city;
  private String state;
  private String number;
  private String complement;
}
