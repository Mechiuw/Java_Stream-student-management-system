package model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Builder
public class ReportCard {
    private String id;
    private Student StudentId;
    private Reports ReportsId;
    private Integer Exams;
    private Integer Homeworks;
}
