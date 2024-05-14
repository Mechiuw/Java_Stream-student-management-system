package service;

import model.dto.request.StudentRequest;
import model.dto.response.StudentResponse;

import java.util.List;

public interface StudentServiceInterface {
    StudentResponse addStudent(StudentRequest studentRequest);
    List<StudentResponse> getAllStudent();
    StudentResponse getById(String id);
    StudentResponse update(String id, StudentRequest studentRequest);
    void delete(String id);
}
