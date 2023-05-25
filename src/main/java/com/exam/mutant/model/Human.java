package com.exam.mutant.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="Human")
public class Human {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;

    @Column(name = "DNA")
    String dna;

    @Column(name = "IS_MUTANT")
    Boolean isMutant;

    @Column(name = "DATE_ADD")
    LocalDateTime dateAdd;

}
