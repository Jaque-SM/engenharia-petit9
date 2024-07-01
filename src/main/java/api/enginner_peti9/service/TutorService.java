package api.enginner_peti9.service;

import api.enginner_peti9.entity.Pet;
import api.enginner_peti9.entity.Tutor;
import api.enginner_peti9.entity.enums.VacinaTipos;
import api.enginner_peti9.exception.AlreadyNameException;
import api.enginner_peti9.exception.NotRegisteredException;
import api.enginner_peti9.exception.VacinaOpcaoException;
import api.enginner_peti9.repository.PetRepository;
import api.enginner_peti9.repository.TutorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class TutorService {

    private TutorRepository tutorRepository;
    private PetRepository petRepository;
    private static final AtomicInteger count = new AtomicInteger();

    public Tutor create(Tutor tutor) {
        int nextVal = count.incrementAndGet() + count.getAndIncrement();
        tutor.setCode(nextVal);
//        validateVaccine(tutor);
        if (tutorRepository.findByNameIgnoreCase(tutor.getName()).isPresent()){
            throw new AlreadyNameException(tutor.getName());
        }
        //addPet(tutor);
        return tutorRepository.save(tutor);
    }

    public Tutor update(Tutor model) {
        validateVaccine(model);
        Tutor fromDB = tutorRepository
                .findById(model.getId()).orElseThrow(() -> new NotRegisteredException(
                        model.getId(), Tutor.class.getSimpleName()));
        model.setId(fromDB.getId());
        addPet(model);
        return tutorRepository.save(model);
    }

    public List<Tutor> listAll() {
        return tutorRepository.findAll();
    }

    public List<Tutor> listByCodeTutor(int code){
        return tutorRepository.findByCode(code);
    }

    public List<Tutor> listByNameTutor(String name){
        return tutorRepository.findByNameIgnoreCaseStartsWith(name);
    }

    public Pet listByCodePet(int code){
        Optional<Pet> pet = petRepository.findByCode(code);
        return pet.get();
    }

    public List<Pet> listByNamePet(String name){
        return petRepository.findByName(name);
    }

    public void delete(Long id) {
        if(!tutorRepository.existsById(id)) {
            throw new NotRegisteredException(id, TutorRepository.class.getSimpleName());
        }
        tutorRepository.deleteById(id);
    }

    private void validateVaccine(Tutor tutor){
        tutor.getPets().forEach(p-> {
            if (!(p.getTipoVacina() == null || VacinaTipos.contemValor(p.getTipoVacina()))) {
                throw new VacinaOpcaoException(String.format("Vacina=%s", p.getTipoVacina()));
            }
        });
    }

    private void addPet(Tutor tutor){
        List<Pet> petsFromDb = new ArrayList<>();

        tutor.getPets().forEach(p-> {
            if (tutor.getId() == null) {
                if (petRepository.findByNameIgnoreCase(p.getName()).isPresent() && petRepository.findByCode(p.getCode()).isPresent()){
                    throw new AlreadyNameException(p.getName());
                }
                int nextVal = count.incrementAndGet() + count.getAndIncrement();
                p.setCode(nextVal);
                p.getTutor().setId(p.getId());
               petsFromDb.add(petRepository.findByNameIgnoreCase(p.getName())
                        .orElse(petRepository.save(p)));
            }
            else {
                petsFromDb.add(p);
                tutor.setPets(petsFromDb);
                petRepository.save(p);
            }
        });

    }
}
