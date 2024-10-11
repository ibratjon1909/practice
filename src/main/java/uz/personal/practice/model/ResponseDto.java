package uz.personal.practice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {

    private int statusCode;
    private String message;
    private LocalDateTime timeStamp;
    private Object object;

    public ResponseDto(int statusCode, String message, LocalDateTime timeStamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timeStamp = timeStamp;
    }
}
