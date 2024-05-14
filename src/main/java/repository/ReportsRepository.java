package repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import model.dto.request.ReportsRequest;
import model.dto.response.ReportsResponse;
import model.entity.Reports;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
@ToString
public class ReportsRepository {
    private List<Reports> reportsRepos;
    public ReportsResponse post(ReportsRequest reportsRequest){
        Reports reports = Reports.builder()
                .subject(reportsRequest.getSubject())
                .unit(reportsRequest.getUnit())
                .semester(reportsRequest.getSemester())
                .year(reportsRequest.getYear())
                .build();
        reportsRepos.add(reports);

        return ReportsResponse.builder()
                .subject(reports.getSubject())
                .unit(reports.getUnit())
                .semester(reports.getSemester())
                .year(reports.getYear())
                .build();
    }
    public List<ReportsResponse> getAll(){

        List<Reports> reports = reportsRepos.stream().toList();
        return reports.stream()
                .map(this::convertToReportsResponse)
                .collect(Collectors.toList());
    }

    public ReportsResponse convertToReportsResponse(Reports reports){
        return ReportsResponse.builder()
                .subject(reports.getSubject())
                .unit(reports.getSubject())
                .semester(reports.getSemester())
                .year(reports.getYear())
                .build();
    }

    public ReportsResponse getById(String id){
        Optional<Reports> reportsOptional = reportsRepos.stream().filter(reports -> reports.getUnit().equals(id)).findFirst();

        if(reportsOptional.isPresent()){
            Reports reports = reportsOptional.get();

            return ReportsResponse.builder()
                    .subject(reports.getSubject())
                    .unit(reports.getUnit())
                    .semester(reports.getSemester())
                    .year(reports.getYear())
                    .build();
        } else {
            return ReportsResponse.builder()
                    .subject("... subject not found")
                    .unit("... unit not found")
                    .semester(0)
                    .year("... year not found")
                    .build();
        }
    }

    public ReportsResponse update(String id, ReportsRequest reportsRequest){

        Optional<Reports> reportsOptional = reportsRepos.stream().filter(reports -> reports.getUnit().equals(id)).findFirst();

        if(reportsOptional.isPresent()){
            Reports reports = reportsOptional.get();

            reports.setSubject(reportsRequest.getSubject());
            reports.setSemester(reportsRequest.getSemester());
            reports.setYear(reportsRequest.getYear());

            // Return updated reports response
            return ReportsResponse.builder()
                    .subject(reports.getSubject())
                    .unit(reports.getUnit())
                    .semester(reports.getSemester())
                    .year(reports.getYear())
                    .build();
        } else {
            return ReportsResponse.builder()
                    .subject("...subject not found")
                    .unit("...unit not found")
                    .semester(0)
                    .year("...year not found")
                    .build();
        }
    }

    public void delete(String id){
        Optional<Reports> reportsOptional = reportsRepos.stream().filter(reports -> reports.getUnit().equals(id)).findFirst();

        if(reportsOptional.isPresent()){
            Reports reports = reportsOptional.get();
            reportsRepos.remove(reports);
        } else {
            System.out.println("reports not found");
        }
    }

}
