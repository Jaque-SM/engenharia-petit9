package api.enginner_peti9.dto.assembler;

import api.enginner_peti9.dto.response.TutorModel;
import api.enginner_peti9.entity.Tutor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TutorModelAssembler {

    private PetModelAssembler petModelAssembler;

    public TutorModel toModel(Tutor domainTutor) {
        var model = new TutorModel();

        model.setId(domainTutor.getId());
        model.setCode(domainTutor.getCode());
        model.setName(domainTutor.getName());
        model.setNickname(domainTutor.getNickname());
        model.setPets(this.petModelAssembler.toCollectionModel(domainTutor.getPets()));

        return model;
    }

    public List<TutorModel> toCollectionModel(List<Tutor> entities) {
        return entities.stream().map(this::toModel).toList();
    }

}
