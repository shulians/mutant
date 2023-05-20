package com.exam.mutant.dto;

import com.exam.mutant.dto.response.ResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ErrorDTO extends ResponseDTO {
    private String message;
}
