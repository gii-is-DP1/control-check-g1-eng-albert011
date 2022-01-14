package org.springframework.samples.petclinic.vacination;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Component;

@Component
public class VaccineFormatter implements Formatter<Vaccine>{

    @Autowired
    private VaccinationService vaccinationService;

    
    @Override
    public String print(Vaccine object, Locale locale) {
        // TODO Auto-generated method stub
        return object.getName();
    }

    @Override
    public Vaccine parse(String text, Locale locale) throws ParseException {
        // TODO Auto-generated method stub
        Vaccine vaccine = vaccinationService.getVaccine(text);
        if(vaccine == null) throw new ParseException("The vaccine did not exists", 0);
        return vaccine;
    }
    
}
