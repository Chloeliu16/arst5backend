package com.example.arst5backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReserveResponse {
    boolean isSuccess;
    String failureReason;
}
