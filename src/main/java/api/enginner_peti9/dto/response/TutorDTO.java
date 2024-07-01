package api.enginner_peti9.dto.response;

import api.enginner_peti9.entity.Tutor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorDTO {
    private Long id;
    private int code;
    private String name;
    private String nickname;
    private List<PetModel> pets;

}
