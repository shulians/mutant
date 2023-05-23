package com.exam.mutant.controller;

import com.exam.mutant.dto.request.MutantReqDTO;
import com.exam.mutant.exception.BusinessException;
import com.exam.mutant.exception.TechnicalException;
import com.exam.mutant.service.IMutantService;
import com.exam.mutant.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MutantControllerTest {
    @InjectMocks
    private MutantController controller;

    @Mock
    private IMutantService service;

    @Test
    public void isMutantTest() throws BusinessException, TechnicalException {
        MutantReqDTO mutantReqDTO = TestUtil.getMutantReqDTO();

        controller.isMutant(mutantReqDTO);

        verify(service, times(1)).isMutant(TestUtil.DNA_MUTANT);
    }
}
