package api.enginner_peti9.dto.patch;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class PetUpdate {
    @NotNull
    private Long id;
    @NotNull
    private int code;
    @NotNull
    @Size(max = 100)
    private String name;
    @NotNull
    @Size(max = 30)
    private String raça;
    @NotNull
    @Size(max = 10)
    private String cor;
    @NotNull
    @Size(max = 10)
    private String peso;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataNascimento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataVacina;
    private String tipoVacina; //enum de tipos de vacina
}
