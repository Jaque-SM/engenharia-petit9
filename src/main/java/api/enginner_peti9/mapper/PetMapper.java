package api.enginner_peti9.mapper;

import api.enginner_peti9.dto.response.PetOutDTO;
import api.enginner_peti9.entity.Pet;
import api.enginner_peti9.service.TutorService;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { TutorService.class })
public interface PetMapper {

    PetOutDTO toDTO(Pet pet);
}

