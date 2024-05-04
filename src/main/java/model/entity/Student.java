package model.entity;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@Builder
public class Student {
    private String Id;
    private String firstName;
    private String lastName;
    private String major;
    private String dateOfBirth;
    private String email;
    private String phoneNum;
}
