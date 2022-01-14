package org.springframework.samples.petclinic.vacination;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.pet.PetType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="vaccines")
public class Vaccine extends BaseEntity {
    //Integer id;

    @Size(min=3, max=50)
    @Column(name="name",nullable = false, unique=true)
    String name;

    @Min(0)
    @Column(name="price", nullable = false)
    Double price;

    @NotNull
    @ManyToOne
    @JoinColumn(name="pet_type_id", nullable = false)
    PetType petType;
}
