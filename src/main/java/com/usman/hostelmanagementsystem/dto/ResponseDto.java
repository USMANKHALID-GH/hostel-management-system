package com.usman.hostelmanagementsystem.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto extends BaseDto{
    @Builder.Default
    private boolean success = true;
    @Builder.Default
    private int statusCode = HttpStatus.OK.value();
    @Builder.Default
    private String status = HttpStatus.OK.name();
    private String message;
    @Builder.Default
    private long timestamp = System.currentTimeMillis();
}
