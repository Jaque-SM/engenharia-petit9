package api.enginner_peti9.dto.assembler;

import api.enginner_peti9.dto.response.PetModel;
import api.enginner_peti9.entity.Pet;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PetModelAssembler {

    public PetModel toModel(Pet domainPet) {
        var petModel = new PetModel();
        petModel.setCode(domainPet.getCode());
        petModel.setName(domainPet.getName());
        petModel.setRaca(domainPet.getRaca());
        petModel.setCor(domainPet.getCor());
        petModel.setPeso(domainPet.getPeso());
        petModel.setDataNascimento(domainPet.getDataNascimento());
        petModel.setDataVacina(domainPet.getDataVacina());
        petModel.setTipoVacina(domainPet.getTipoVacina());
        return petModel;
    }

    public List<PetModel> toCollectionModel(List<Pet> entities) {
        return entities.stream().map(this::toModel).toList();
    }

}
