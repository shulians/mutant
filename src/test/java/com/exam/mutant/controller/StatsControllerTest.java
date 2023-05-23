package com.exam.mutant.controller;

import com.exam.mutant.dto.request.MutantReqDTO;
import com.exam.mutant.dto.response.StatsResDTO;
import com.exam.mutant.exception.BusinessException;
import com.exam.mutant.exception.TechnicalException;
import com.exam.mutant.service.IMutantService;
import com.exam.mutant.service.IStatsService;
import com.exam.mutant.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StatsControllerTest {

    @InjectMocks
    private StatsController controller;

    @Mock
    private IStatsService service;

    @Test
    public void getStatDNATest() {
        StatsResDTO stat = TestUtil.getStatsResDTO();

        when(service.getStatDNA()).thenReturn(stat);

        ResponseEntity<StatsResDTO> response = controller.getStatDNA();

        Assert.assertEquals(response.getBody(), stat);
    }
}
