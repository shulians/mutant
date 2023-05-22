package com.exam.mutant.controller;

import com.exam.mutant.dto.response.StatsResDTO;
import com.exam.mutant.service.IStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {
    IStatsService service;

    @Autowired
    public StatsController(IStatsService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<StatsResDTO> getStatDNA(){
        return ResponseEntity.ok(service.getStatDNA());
    }


}
