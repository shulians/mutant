package com.exam.mutant.service.Impl;

import com.exam.mutant.exception.BusinessException;
import com.exam.mutant.exception.TechnicalException;
import com.exam.mutant.model.Human;
import com.exam.mutant.repository.HumanRepository;
import com.exam.mutant.service.impl.MutantServiceImpl;
import com.exam.mutant.util.TestUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class MutantServiceTestImpl {
    @InjectMocks
    private MutantServiceImpl service;

    @Mock
    private HumanRepository repository;

    @Test
    public void isMutantTest() throws BusinessException, TechnicalException {
        Human human = TestUtil.getHumanMutant();

        try(MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(TestUtil.LOCAL_DATE_TIME);

            when(repository.save(human)).thenReturn(human);
            Boolean isMutant = service.isMutant(TestUtil.DNA_MUTANT);

            Assert.assertEquals(isMutant, Boolean.TRUE);
        }
    }

    @Test
    public void isNotMutantTest() {
        Human human = TestUtil.getHuman();

        try(MockedStatic<LocalDateTime> mock = mockStatic(LocalDateTime.class)) {
            mock.when(LocalDateTime::now).thenReturn(TestUtil.LOCAL_DATE_TIME);

            when(repository.save(human)).thenReturn(human);

            assertThrows(BusinessException.class, () -> service.isMutant(TestUtil.DNA_NOT_MUTANT));
        }
    }

    @Test
    public void isCharactersNotRepresentDnaTest() {
        assertThrows(TechnicalException.class, () -> service.isMutant(TestUtil.DNA_NOT_REPRESENT));
    }

}
