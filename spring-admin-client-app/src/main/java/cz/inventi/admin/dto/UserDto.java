package cz.inventi.admin.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserDto extends AbstractDto {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email(message = "Email address is not valid.")
    private String email;
    @NotNull
    private LocalDate dateOfBirth;
    @Valid
    @NotNull
    private AddressDto address;
}