package api.enginner_peti9.mapper;
import api.enginner_peti9.dto.patch.TutorUpdate;
import api.enginner_peti9.dto.post.TutorCreate;
import api.enginner_peti9.dto.response.TutorOutDTO;
import api.enginner_peti9.entity.Tutor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TutorMapper {
    Tutor toModel(TutorCreate tutorCreate);
    Tutor toModel(TutorUpdate tutorUpdate);
    TutorOutDTO toDTO(Tutor tutor);
}
