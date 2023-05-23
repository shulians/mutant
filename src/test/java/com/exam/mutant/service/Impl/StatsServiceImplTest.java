package com.exam.mutant.service.Impl;

import com.exam.mutant.dto.response.StatsResDTO;
import com.exam.mutant.repository.HumanRepository;
import com.exam.mutant.service.impl.StatsServiceImpl;
import com.exam.mutant.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatsServiceImplTest {
    @InjectMocks
    private StatsServiceImpl service;

    @Mock
    private HumanRepository repository;

    @Test
    public void getStatDNATest() {
        when(repository.count()).thenReturn(TestUtil.LONG_NUMBER);
        when(repository.countByIsMutant(Boolean.TRUE)).thenReturn(TestUtil.LONG_NUMBER_1);
        StatsResDTO response = service.getStatDNA();

        Assert.assertEquals(response.getRatio(), TestUtil.BIG_DECIMAL_NUMBER);
    }

}
