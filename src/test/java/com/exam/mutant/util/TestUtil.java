package com.exam.mutant.util;

import com.exam.mutant.dto.request.MutantReqDTO;
import com.exam.mutant.dto.response.StatsResDTO;
import com.exam.mutant.model.Human;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TestUtil {
    public final static String DNA_MUTANT_STRING = "ATGCGA,CAGTGC,TTATGT,AGAAGG,CCCCTA,TCACTG";
    public final static String DNA_NOT_MUTANT_STRING = "CTGCGA,CAGTTC,TTATGT,AGAAGG,CCCTTA,TCACTG";
    public final static LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2023, 05, 25,12,00);
    public final static String[] DNA_MUTANT = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};;
    public final static String[] DNA_NOT_MUTANT = {"CTGCGA","CAGTTC","TTATGT","AGAAGG","CCCTTA","TCACTG"};
    public final static String[] DNA_NOT_REPRESENT = {"ZTGCZA","CAGTTC","TTATGT","AGAXGG","CHCTTA","TCACPG"};
    public final static Long LONG_NUMBER = 100L;
    public final static Long LONG_NUMBER_1 = 40L;
    public final static BigDecimal BIG_DECIMAL_NUMBER = new BigDecimal("0.4");

    public static MutantReqDTO getMutantReqDTO(){
        return MutantReqDTO.builder()
                .dna(DNA_MUTANT)
                .build();
    }

    public static Human getHumanMutant(){
        return Human.builder()
                .dna(DNA_MUTANT_STRING)
                .isMutant(Boolean.TRUE)
                .dateAdd(LOCAL_DATE_TIME)
                .build();
    }

    public static Human getHuman(){
        return Human.builder()
                .dna(DNA_NOT_MUTANT_STRING)
                .isMutant(Boolean.FALSE)
                .dateAdd(LOCAL_DATE_TIME)
                .build();
    }

    public static StatsResDTO getStatsResDTO(){
        return StatsResDTO.builder()
                          .count_human_dna(LONG_NUMBER)
                          .count_mutant_dna(LONG_NUMBER_1)
                          .ratio(BIG_DECIMAL_NUMBER)
                          .build();
    }


}


