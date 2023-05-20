package com.exam.mutant.service.impl;

import com.exam.mutant.exception.BusinessException;
import com.exam.mutant.exception.TechnicalException;
import com.exam.mutant.service.IMutantService;
import com.exam.mutant.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MutantServiceImpl implements IMutantService {

    @Override
    public boolean isMutant(String[] dna) throws TechnicalException, BusinessException {
        var isMutant = Boolean.FALSE;

        if(isDnaValid(dna)){
            if(countSequenceOfFourLetters(dna) > 1) {
                isMutant = Boolean.TRUE;
            }else {
                throw new BusinessException("DNA does not correspond to a mutant");
            }
        }else{
            throw new TechnicalException("There are characters that do not represent the nitrogenous base of DNA");
        }

        return isMutant;
    }

    private boolean isDnaValid(String[] dna){
        String[] listDna = {"A","T","C","G"};
        boolean isValid = Arrays.asList(dna).stream().allMatch(item -> StringUtils.isMatch(listDna,item));
        return isValid;
    }

    public int countSequenceOfFourLetters(String[] dna){
        return dna.length;
    }
}
