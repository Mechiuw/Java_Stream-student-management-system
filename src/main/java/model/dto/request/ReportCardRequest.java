package model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import model.entity.Reports;
import model.entity.Student;

@Data
@Builder
@AllArgsConstructor
public class ReportCardRequest {
    private String id;
    private Student StudentId;
    private Reports ReportsId;
    private Integer Exams;
    private Integer Homeworks;
}
