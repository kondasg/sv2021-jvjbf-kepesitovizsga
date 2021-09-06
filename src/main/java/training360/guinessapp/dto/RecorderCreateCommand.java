package training360.guinessapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import training360.guinessapp.DateOfBirth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecorderCreateCommand {

    @NotBlank(message = "must not be blank")
    private String name;
    @DateOfBirth(message = "must be in the past")
    private LocalDate dateOfBirth;
}
