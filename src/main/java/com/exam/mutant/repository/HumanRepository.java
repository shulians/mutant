package com.exam.mutant.repository;

import com.exam.mutant.model.Human;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HumanRepository {
    List<Human> list = new ArrayList<>();

    public void save(String[] dna, Boolean isMutant){
        String str = String.join(",", dna);

        Human mutant = Human.builder()
                                          .id(list.size()+1)
                                          .dna(str)
                                          .isMutant(isMutant).build();

        list.add(mutant);
    }

    public List<Human> findAll(){
        return list;
    }

}
