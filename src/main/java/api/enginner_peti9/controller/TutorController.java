package api.enginner_peti9.controller;

import api.enginner_peti9.dto.patch.TutorUpdate;
import api.enginner_peti9.dto.post.TutorCreate;
import api.enginner_peti9.dto.response.TutorOutDTO;
import api.enginner_peti9.entity.Tutor;
import api.enginner_peti9.mapper.TutorMapper;
import api.enginner_peti9.service.TutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peti9/engenharia")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class TutorController {
    private final Logger logger = LoggerFactory.getLogger(TutorController.class);
    private final TutorMapper mapper;
    private final TutorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TutorOutDTO create(@RequestBody @Valid TutorCreate dto) {
        logger.trace("create: {}", dto.getName());
        return mapper.toDTO(service.criar(mapper.toModel(dto)));
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TutorOutDTO update(@PathVariable Long id, @RequestBody @Valid TutorUpdate dto) {
        logger.trace("update: {}", dto.getName());
        Tutor model = mapper.toModel(dto);
        model.setId(id);
        return mapper.toDTO(service.update(mapper.toModel(dto)));
    }

    @GetMapping("/all")
    public List<TutorOutDTO> listAll() {
        logger.trace("listAll");
        return service.listAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        logger.trace("delete: {}", id);
        service.delete(id);
    }


}
