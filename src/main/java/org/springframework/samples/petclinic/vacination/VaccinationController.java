package org.springframework.samples.petclinic.vacination;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/vaccination")
public class VaccinationController {

    @Autowired
    private VaccinationService vaccinationService;

    @Autowired
    private PetService petService;


    private static final String VIEWS_vACCINATION_CREATE_OR_UPDATE_FORM = "vaccination/createOrUpdateVaccinationForm";

    @ModelAttribute("vaccines")
    public Collection<Vaccine> populateVaccines(){
        return vaccinationService.getAllVaccines();
    }

    @ModelAttribute("pets")
    public Collection<Pet> populatePets(){
        return petService.findAllPets();
    }
    @GetMapping(path = "/create")
    public String initCreationForm(Vaccination vaccination, ModelMap model){
        model.put("vaccination", vaccination);
        return VIEWS_vACCINATION_CREATE_OR_UPDATE_FORM;

    }

    @PostMapping(path = "/create")
    public String processCreationForm(@Valid Vaccination vaccination, BindingResult result, ModelMap model) throws UnfeasibleVaccinationException{
        try{
            if(result.hasErrors()){
                model.put("vaccination", vaccination);
                return VIEWS_vACCINATION_CREATE_OR_UPDATE_FORM;
            }
            Vaccination saved = vaccinationService.save(vaccination);
            return "welcome";
        }catch (UnfeasibleVaccinationException e){
            model.put("errors", e);
            return VIEWS_vACCINATION_CREATE_OR_UPDATE_FORM;
        }
        

        
    }
    
}
