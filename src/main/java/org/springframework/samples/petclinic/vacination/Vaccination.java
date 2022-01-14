package org.springframework.samples.petclinic.vacination;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.Pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="vaccinations")
public class Vaccination extends BaseEntity{
    //Integer id; Implementado en BaseEntity


    //falla al meter datos a la bd con el nullable false en el column
    @NotNull
    @Column(name="date", nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    LocalDate date;


    @ManyToOne
    @JoinColumn(name="vaccinated_pet_id", nullable = false)
    Pet vaccinatedPet;   

    //@Transient
    @ManyToOne
    @JoinColumn(name="vaccine_id", nullable = false)
    Vaccine vaccine; 
}
