package cz.inventi.admin.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@EqualsAndHashCode(callSuper = true)
@Data
public class AddressDto extends AbstractDto {
    @NotBlank
    @Pattern(regexp = "^(\\D|\\d)+[\\s](\\D|\\d)+$", message = "Format not valid. Expected example: [streetName 12]")
    private String street1;
    @NotBlank
    @Pattern(regexp = "^(\\D|\\d)+[\\s](\\D|\\d)+$", message = "Format not valid. Expected example: [streetName 12]")
    private String street2;
    @NotBlank
    private String city;
    @NotBlank
    @Pattern(regexp = "\\d{5}", message = "Format not valid. Expected number with length 5")
    private String zip;
    @NotBlank
    private String country;
}
