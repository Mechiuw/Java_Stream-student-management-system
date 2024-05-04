package repository;

import lombok.*;
import model.entity.Student;
import model.dto.request.StudentRequest;
import model.dto.response.StudentResponse;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Builder
@ToString
public class StudentRepository {
    private List<Student> studentRepos;
    public StudentResponse post(StudentRequest studentRequest){
        Student student = Student.builder()
                .Id(studentRequest.getId())
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .major(studentRequest.getMajor())
                .email(studentRequest.getEmail())
                .dateOfBirth(studentRequest.getDateOfBirth())
                .phoneNum(studentRequest.getPhoneNum())
                .build();
            studentRepos.add(student);

        return StudentResponse.builder()
                .firstname(student.getFirstName())
                .id(student.getId())
                .major(student.getMajor())
                .email(student.getEmail())
                .build();
    }
    public List<StudentResponse> getAll(){

        List<Student> students = studentRepos.stream().collect(Collectors.toList());
        return students.stream()
                .map(this::convertToStudentResponse)
                .collect(Collectors.toList());
    }

    public StudentResponse convertToStudentResponse(Student student){
        return StudentResponse.builder()
                .firstname(student.getFirstName())
                .id(student.getId())
                .major(student.getMajor())
                .email(student.getEmail())
                .build();
    }

    public StudentResponse getById(String id){
        Optional<Student> studentOptional = studentRepos.stream().filter(student -> student.getId().equals(id)).findFirst();

        if(studentOptional.isPresent()){
            Student students = studentOptional.get();

            return StudentResponse.builder()
                    .firstname(students.getFirstName())
                    .id(students.getId())
                    .email(students.getEmail())
                    .major(students.getMajor())
                    .build();
        } else {
            return StudentResponse.builder()
                    .firstname("firstname not found")
                    .id("Id not found")
                    .email("email not found")
                    .major("major not found")
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
