package com.exam.mutant.service.impl;

import com.exam.mutant.dto.response.StatsResDTO;
import com.exam.mutant.repository.HumanRepository;
import com.exam.mutant.service.IStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class StatsServiceImpl implements IStatsService {
    HumanRepository repository;

    @Autowired
    public StatsServiceImpl(HumanRepository repository) {
        this.repository = repository;
    }

    @Override
    public StatsResDTO getStatDNA() {
        StatsResDTO stats = StatsResDTO.builder().build();

        Long countH =  repository.count();
        Long countM = repository.countByIsMutant(Boolean.TRUE);

        if(countH > 0) {
            BigDecimal bigCountH = BigDecimal.valueOf(countH);
            BigDecimal bigCountM = BigDecimal.valueOf(countM);
            BigDecimal ratio = bigCountM.divide(bigCountH, 1, RoundingMode.HALF_UP);

            stats.setCount_human_dna(countH);
            stats.setCount_mutant_dna(countM);
            stats.setRatio(ratio);
        }
        return stats;
    }
}
