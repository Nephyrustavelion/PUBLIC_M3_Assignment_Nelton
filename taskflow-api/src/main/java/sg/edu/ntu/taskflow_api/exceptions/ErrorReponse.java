package sg.edu.ntu.taskflow_api.exceptions;

import java.time.LocalDateTime;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorReponse {
    private String message;
    private LocalDateTime timestamp;
}