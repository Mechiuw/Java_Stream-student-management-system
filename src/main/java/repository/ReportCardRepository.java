package repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import model.dto.request.ReportCardRequest;
import model.dto.response.ReportCardResponse;
import model.dto.response.ReportsResponse;
import model.entity.ReportCard;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public List<ReportCardResponse> getAll(){
        List<ReportCard> response = reportCardList.stream().toList();
        Stream<ReportCardResponse> rex = response.stream().map(resp ->
            ReportCardResponse.builder()
                    .StudentId(resp.getStudentId())
                    .ReportsId(resp.getReportsId())
                    .Exams(resp.getExams())
                    .Homeworks(resp.getHomeworks())
                .build()
        );
        return rex.toList();
    }

    public ReportCardResponse getById(ReportCardRequest reportCardRequest){
        return reportCardList.stream()
                .filter(reportCard -> reportCard.getStudentId().equals(reportCardRequest.getStudentId()))
                .map(reportCard -> ReportCardResponse.builder()
                        .StudentId(reportCard.getStudentId())
                        .ReportsId(reportCard.getReportsId())
                        .Exams(reportCard.getExams())
                        .Homeworks(reportCard.getHomeworks())
                        .build())
                .findFirst().orElse(ReportCardResponse.builder()
                        .StudentId(null)
                        .ReportsId(null)
                        .Exams(0)
                        .Homeworks(0)
                        .build());
    }


}
