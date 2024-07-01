package api.enginner_peti9.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorModel {

    private Long id;
    private int code;
    private String name;
    private String nickname;
    private List<PetModel> pets;

}
