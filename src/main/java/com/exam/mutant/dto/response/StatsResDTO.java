package com.exam.mutant.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StatsResDTO extends ResponseDTO{
    Integer count_mutant_dna;
    Integer count_human_dna;
    BigDecimal ratio;
}
