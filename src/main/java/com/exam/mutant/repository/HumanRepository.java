package com.exam.mutant.repository;

import com.exam.mutant.model.Human;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HumanRepository extends JpaRepository<Human, Integer> {
    long countByIsMutant(Boolean isMutant);
}

   /* public void save(String[] dna, Boolean isMutant){
        String str = String.join(",", dna);

        Human mutant = Human.builder()
                .id(list.size()+1)
                .dna(str)
                .isMutant(isMutant).build();

        list.add(mutant);
    }

    public List<Human> findAll(){
        return list;
    }*/
