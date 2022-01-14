package org.springframework.samples.petclinic.vacination;

import java.util.List;
import java.util.Optional;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationRepository extends CrudRepository<Vaccination,Integer>{
    
    @Query("SELECT v FROM Vaccination v")
    List<Vaccination> findAll();

    @Query("SELECT vc FROM Vaccine vc")
    List<Vaccine> findAllVaccines();

    @Query("SELECT v FROM Vaccination v WHERE v.id = ?1")
    Optional<Vaccination> findById(int id);

    @Query("SELECT vc FROM Vaccine vc WHERE vc.name = ?1")
    Vaccine findVaccine(String typeName);


    Vaccination save(Vaccination p);
}
