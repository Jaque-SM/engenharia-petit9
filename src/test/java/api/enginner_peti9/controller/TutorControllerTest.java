package api.enginner_peti9.controller;

import api.enginner_peti9.builders.TutorBuilder;
import api.enginner_peti9.dto.patch.TutorUpdate;
import api.enginner_peti9.dto.post.TutorCreate;
import api.enginner_peti9.dto.response.TutorOutDTO;
import api.enginner_peti9.entity.Tutor;
import api.enginner_peti9.mapper.TutorMapper;
import api.enginner_peti9.service.TutorService;
import api.enginner_peti9.utils.JsonConvertionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TutorControllerTest {

    private static final String CRIAR_ROTA = "/api/peti9/engenharia";
    private static final String ALTERAR_ROTA = "/api/peti9/engenharia/{id";
    private static final String DELETAR_ROTA = "/api/peti9/engenharia/{id}";
    private static final String LIST_ALL = "/api/peti9/engenharia/all";
    private static final String LIST_CODE_TUTOR_ROTA = "/api/peti9/engenharia/tutor/code/{code}";
    private static final String LIST_NOME_TUTOR_ROTA = "/api/peti9/engenharia/tutor/name/{name}";
    private static final String BUSCAR_CODE_PET_ROTA = "/api/peti9/engenharia/pet/code/{code}";

    @Mock
    private ApplicationEventPublisher publisher;
    private MockMvc mockMvc;
    @Mock
    private TutorService service;
    @InjectMocks
    private TutorController controller;
    @Mock
    private TutorMapper mapper;
    private TutorCreate cadastroDTO;
    private TutorUpdate atualizacaoDTO;
    private TutorOutDTO outDTO;
    private Tutor model;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();

        cadastroDTO = TutorBuilder.buildTutorCreate();
        atualizacaoDTO = TutorBuilder.buildTutorUpdate();
        outDTO = TutorBuilder.buildTutorOutDTO();
        model = TutorBuilder.buildLTutor();
    }

    @Test
    void testCreate201() throws Exception {
        when(mapper.toModel(cadastroDTO)).thenReturn(model);
        when(mapper.toDTO(model)).thenReturn(outDTO);
        when(service.create(model)).thenReturn(model);

        mockMvc.perform(MockMvcRequestBuilders.post(CRIAR_ROTA)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(cadastroDTO)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome", is(outDTO.getName())));
    }

    @Test
    void update() {
    }

    @Test
    void listAll() {
    }

    @Test
    void listTutorByCode() {
    }

    @Test
    void listTutorByName() {
    }

    @Test
    void getPetByCode() {
    }

    @Test
    void delete() {
    }
}