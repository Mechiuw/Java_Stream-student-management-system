package repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import model.dto.request.ReportsRequest;
import model.dto.request.StudentRequest;
import model.dto.response.ReportsResponse;
import model.dto.response.StudentResponse;
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

    public StudentResponse update(String id, StudentRequest studentRequest){

        Optional<Student> studentOptional = studentRepos.stream().filter(student -> student.getId().equals(id)).findFirst();

        if(studentOptional.isPresent()){
            Student student = studentOptional.get();

            student.setFirstName(studentRequest.getFirstName());
            student.setMajor(studentRequest.getMajor());
            student.setEmail(studentRequest.getEmail());

            // Return updated student response
            return StudentResponse.builder()
                    .firstname(student.getFirstName())
                    .id(student.getId())
                    .major(student.getMajor())
                    .email(student.getEmail())
                    .build();
        } else {
            return StudentResponse.builder()
                    .firstname("firstname not found")
                    .id("id not found")
                    .email("email not found")
                    .major("major not found")
                    .build();
        }
    }

    public void delete(String id){
        Optional<Student> studentOptional = studentRepos.stream().filter(student -> student.getId().equals(id)).findFirst();

        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            studentRepos.remove(student);
        } else {
            System.out.println("student not found");
        }
    }

}
