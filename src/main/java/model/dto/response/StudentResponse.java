package model.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@Data
public class StudentResponse {
    private String firstname;
    private String id;
    private String major;
    private String email;
}
