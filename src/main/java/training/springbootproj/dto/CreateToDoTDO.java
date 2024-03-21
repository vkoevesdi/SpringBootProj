package training.springbootproj.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CreateToDoTDO {

    @NotBlank
    @Size(min = 5, max = 20)
    private String text;

    @Null
    private final Boolean completed = false;
}
