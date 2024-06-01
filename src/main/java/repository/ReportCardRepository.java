package repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import model.dto.request.ReportCardRequest;
import model.dto.response.ReportCardResponse;
import model.dto.response.ReportsResponse;
import model.entity.ReportCard;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
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

    public ReportCardResponse getById(String id) {
        try{
            Optional<ReportCard> response = reportCardList.stream().filter(x -> x.getId().equals(id)).findFirst();
            return response.map(reportCard -> ReportCardResponse.builder()
                    .StudentId(reportCard.getStudentId())
                    .ReportsId(reportCard.getReportsId())
                    .Exams(reportCard.getExams())
                    .Homeworks(reportCard.getHomeworks())
                    .build()).orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ReportCardRequest update(String id, ReportCardRequest reportCardRequest){


        return null;
    }




}
