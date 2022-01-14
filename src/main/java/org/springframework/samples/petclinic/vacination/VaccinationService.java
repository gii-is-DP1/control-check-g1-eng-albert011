package org.springframework.samples.petclinic.vacination;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.stereotype.Service;

@Service
public class VaccinationService {
    @Autowired
    private VaccinationRepository vaccinationRepository;

    @Transactional
    public List<Vaccination> getAll(){
        return vaccinationRepository.findAll();
    }

    @Transactional
    public List<Vaccine> getAllVaccines(){
        return vaccinationRepository.findAllVaccines();
    }

    @Transactional
    public Vaccine getVaccine(String typeName) {
        return vaccinationRepository.findVaccine(typeName);
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = UnfeasibleVaccinationException.class)
    public Vaccination save(Vaccination p) throws UnfeasibleVaccinationException {
        Pet vaccinatedPet = p.getVaccinatedPet();
        if(!(vaccinatedPet.getType().equals(p.getVaccine().getPetType()))) throw new UnfeasibleVaccinationException();
        vaccinationRepository.save(p);
        return p;       
    }

    
}
