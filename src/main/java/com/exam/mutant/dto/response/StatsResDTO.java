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
    Long count_mutant_dna;
    Long count_human_dna;
    BigDecimal ratio;
}
