package api.enginner_peti9.dto.assembler;

import api.enginner_peti9.dto.post.PetCreate;
import api.enginner_peti9.entity.Pet;
import org.springframework.stereotype.Component;

@Component
public class PetCreateDisassembler {

    public Pet toDomainObject(PetCreate petCreate) {
        Pet domainPet = new Pet();

        domainPet.setCode(petCreate.getCode());
        domainPet.setName(petCreate.getName());
        domainPet.setCode(petCreate.getCode());
        domainPet.setCor(petCreate.getCor());
        domainPet.setPeso(petCreate.getPeso());
        domainPet.setRaca(petCreate.getRaca());
        domainPet.setDataVacina(petCreate.getDataVacina());
        domainPet.setTipoVacina(petCreate.getTipoVacina());
        domainPet.setDataNascimento(petCreate.getDataNascimento());

        return domainPet;
    }

}
