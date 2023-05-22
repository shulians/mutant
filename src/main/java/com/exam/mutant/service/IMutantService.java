package com.exam.mutant.service;

import com.exam.mutant.exception.BusinessException;
import com.exam.mutant.exception.TechnicalException;

public interface IMutantService {
    void isMutant(String[] dna) throws BusinessException, TechnicalException;
}
