package api.enginner_peti9.repository;

import api.enginner_peti9.entity.Pet;
import api.enginner_peti9.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
    Optional<Tutor> findByNameIgnoreCase(String name);
    List<Tutor> findByCode(int code);
    List<Tutor> findByNameIgnoreCaseStartsWith(String name);
    List<Tutor> findByPetsCode(int code);
}
