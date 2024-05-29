package model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import model.entity.Reports;
import model.entity.Student;

@Data
@Builder
@AllArgsConstructor
public class ReportCardResponse {
    private Student StudentId;
    private Reports ReportsId;
    private Integer Exams;
    private Integer Homeworks;
}
