package controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import model.dto.request.StudentRequest;
import model.dto.response.StudentResponse;
import service.StudentService;

import java.util.List;


@RequiredArgsConstructor
@Getter
@Setter
public class StudentController {
    private final StudentService studentService;

    public StudentResponse createStudent(StudentRequest studentRequest){
        return studentService.addStudent(studentRequest);
    }
    public List<StudentResponse> viewAllStudents(){
        return studentService.getAllStudent();
    }

    public StudentResponse viewById(String id){
        return studentService.getById(id);
    }
    public StudentResponse updateStudent(String id, StudentRequest studentRequest){
        return studentService.update(id,studentRequest);
    }

    public void deleteStudent(String id){
        studentService.delete(id);
    }
}
