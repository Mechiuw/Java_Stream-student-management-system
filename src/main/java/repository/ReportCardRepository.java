package repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import model.dto.request.ReportCardRequest;
import model.dto.response.ReportCardResponse;
import model.entity.ReportCard;

import java.util.List;

@AllArgsConstructor
@Builder
@ToString
public class ReportCardRepository {
    private List<ReportCard> reportCardList;

    public ReportCardResponse create(ReportCardRequest reportCardRequest){
        ReportCard reportCard = ReportCard.builder()
                .StudentId(reportCardRequest.getStudentId())
                .ReportsId(reportCardRequest.getReportsId())
                .Exams(reportCardRequest.getExams())
                .Homeworks(reportCardRequest.getHomeworks())
                .build();
        reportCardList.add(reportCard);

        return ReportCardResponse.builder()
                .StudentId(reportCard.getStudentId())
                .ReportsId(reportCard.getReportsId())
                .Exams(reportCard.getExams())
                .Homeworks(reportCard.getHomeworks())
                .build();
    }
}
