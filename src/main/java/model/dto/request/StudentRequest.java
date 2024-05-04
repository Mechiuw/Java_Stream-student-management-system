package model.dto.request;

import lombok.*;


@Builder
@AllArgsConstructor
@Data
public class StudentRequest {
    private String Id;
    private String firstName;
    private String lastName;
    private String major;
    private String dateOfBirth;
    private String email;
    private String phoneNum;
}
