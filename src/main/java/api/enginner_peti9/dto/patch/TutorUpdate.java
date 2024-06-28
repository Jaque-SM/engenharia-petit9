package api.enginner_peti9.dto.patch;

import api.enginner_peti9.entity.Pet;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TutorUpdate {
    @NotNull
    private Long id;
    @NotNull
    private int code;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 100)
    private String nickname;
    @Valid
    private List<Pet> pets;
}
