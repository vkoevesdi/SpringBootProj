package training.springbootproj.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateToDoTDO {

    @NotNull
    @Positive
    private Long id;

    @NotBlank
    @Size(min = 5, max = 20)
    private String text;

    @NotNull
    private Boolean completed;
}
