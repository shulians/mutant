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

    public int countSequenceOfFourLetters(String[] dna) {
        int countSequence;

        char[][] tableDna = new char[dna.length][];

        for (int i = 0; i < dna.length; i++) {
            tableDna[i] = dna[i].toCharArray();
        }

        int letterInHorizontalByFour = 0;
        int letterInVerticalByFour = 0;
        int letterInObliqueByFour = 0;

        //horizontal
        for (int y = 0; y < tableDna.length; y++) {
            for (int x = 0; x < tableDna[y].length; x++) {

                //Horizontal
                if(x < tableDna[y].length - 3){
                    if (tableDna[y][x] == tableDna[y][x + 1]
                            && tableDna[y][x] == tableDna[y][x + 2]
                            && tableDna[y][x] == tableDna[y][x + 3]) {
                        letterInHorizontalByFour++;
                    }
                }

                //vertical
                if(y < tableDna.length - 3) {
                    if (tableDna[y][x] == tableDna[y + 1][x]
                            && tableDna[y][x] == tableDna[y + 2][x]
                            && tableDna[y][x] == tableDna[y + 3][x]) {
                        letterInVerticalByFour++;
                    }
                }

                //oblicua (diagonal)
                if(y < tableDna.length - 3 && x < tableDna[y].length - 3) {
                    if (tableDna[y][x] == tableDna[y + 1][x + 1]
                            && tableDna[y][x] == tableDna[y + 2][x + 2]
                            && tableDna[y][x] == tableDna[y + 3][x + 3]) {
                        letterInObliqueByFour++;
                    }
                }

            }
        }

        countSequence = letterInHorizontalByFour + letterInVerticalByFour + letterInObliqueByFour;


        return countSequence;
    }
}

/*
        for (char[] letters : tableDna) {
            for (char letter : letters)
                System.out.print(letter + " ");
            System.out.println();
        }
 */