package api.enginner_peti9.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TutorOutDTO {
    private Long id;
    private int code;
    private String name;
    private String nickname;
    private List<PetOutDTO> pets;
}
