package com.exam.mutant.repository;

import com.exam.mutant.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<Human, Integer> {
    long countByIsMutant(Boolean isMutant);
}