package api.enginner_peti9.dto.assembler;

import api.enginner_peti9.dto.post.TutorCreate;
import api.enginner_peti9.entity.Pet;
import api.enginner_peti9.entity.Tutor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TutorCreateDisassembler {

    public Tutor toDomainObject(TutorCreate tutorCreate) {
        Tutor tutor = new Tutor();
        tutor.setCode(tutorCreate.getCode());
        tutor.setName(tutorCreate.getName());
        tutor.setNickname(tutorCreate.getNickname());

        tutor.setPets(tutorCreate.getPets().stream().map(p -> {
            var pet = new Pet();
            pet.setCode(p.getCode());
            pet.setName(p.getName());
            pet.setCode(p.getCode());
            pet.setCor(p.getCor());
            pet.setPeso(p.getPeso());
            pet.setRaca(p.getRaca());
            pet.setDataVacina(p.getDataVacina());
            pet.setTipoVacina(p.getTipoVacina());
            pet.setDataNascimento(p.getDataNascimento());
            pet.setTutor(tutor);
            return pet;
        }).collect(Collectors.toList()));

        return tutor;
    }

}
