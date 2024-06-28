package api.enginner_peti9.repository;

import api.enginner_peti9.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByNameIgnoreCase(String nome);
    @Query("SELECT code FROM Pet cat JOIN FETCH code.pets")
    Optional<Pet> findByCode(int code);
}
