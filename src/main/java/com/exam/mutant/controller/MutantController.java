package com.exam.mutant.controller;

import com.exam.mutant.dto.request.MutantReqDTO;
import com.exam.mutant.exception.BusinessException;
import com.exam.mutant.exception.TechnicalException;
import com.exam.mutant.service.IMutantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mutant")
public class MutantController{
    IMutantService service;

    @Autowired
    public MutantController(IMutantService service) {
        this.service = service;
    }

    @PostMapping
    public void isMutant(@RequestBody MutantReqDTO req) throws BusinessException, TechnicalException {
        this.service.isMutant(req.getDna());
    }
}
