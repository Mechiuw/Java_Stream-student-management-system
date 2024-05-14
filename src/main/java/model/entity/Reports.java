package model.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class Reports {
    private String subject;
    private String unit;
    private Integer semester;
    private String year;
}
