package api.enginner_peti9.dto.response;

import api.enginner_peti9.entity.Pet;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetOutDTOCode {
    private Long id;
    private int code;
    private String name;
    private String raca;
    private String cor;
    private String peso;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataNascimento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataVacina;
    private String tipoVacina;
    private String tutorName;

    public PetOutDTOCode(Pet pet) {
        this.id=pet.getId();
        this.code=pet.getCode();
        this.name=pet.getName();
        this.raca=pet.getRaca();
        this.cor=pet.getCor();
        this.peso=pet.getPeso();
        this.dataNascimento=pet.getDataNascimento();
        this.dataVacina=pet.getDataVacina();
        this.tipoVacina=pet.getTipoVacina();
        //this.tutorName=pet.getTutor().getName();
    }
}
