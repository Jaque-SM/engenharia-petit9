package api.enginner_peti9.builders;

import api.enginner_peti9.dto.patch.TutorUpdate;
import api.enginner_peti9.dto.post.TutorCreate;
import api.enginner_peti9.dto.response.TutorOutDTO;
import api.enginner_peti9.entity.Tutor;

import java.util.List;

public class TutorBuilder {
    public static Tutor buildLClinica() {
        return Tutor.builder()
                .id(1L)
                .code(1)
                .name("Jaque")
                .nickname("Ja")
                .pets(List.of(PetBuilder))
                .build();
    }

    public static TutorCreate buildTutorCreate() {
        return TutorCreate.builder()
                .code(1)
                .name("Jaque")
                .nickname("Ja")
                .pets()
                .build();
    }

    public static TutorUpdate buildTutorUpdate() {
        return TutorUpdate.builder()
                .id(1L)
                .code(1)
                .name("Jaque")
                .nickname("Ja")
                .pets()
                .build();
    }

    public static TutorOutDTO buildTutorOutDTO() {
        return TutorOutDTO.builder()
                .id(1L)
                .code(1)
                .name("Jaque")
                .nickname("Ja")
                .pets()
                .build();
    }

}
