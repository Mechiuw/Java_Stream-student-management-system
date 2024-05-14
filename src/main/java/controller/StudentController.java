package controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import model.dto.request.StudentRequest;
import model.dto.response.StudentResponse;
import service.StudentServiceInterface;

import java.util.List;


@RequiredArgsConstructor
public class StudentController {
    private final StudentServiceInterface studentService;

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
