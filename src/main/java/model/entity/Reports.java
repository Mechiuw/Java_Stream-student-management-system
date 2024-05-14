package model.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Reports {
    private String subject;
    private String unit;
    private int semester;
    private String year;
}
