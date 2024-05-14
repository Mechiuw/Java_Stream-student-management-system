package service;

import model.dto.request.StudentRequest;
import model.dto.response.StudentResponse;

import java.util.List;

public interface StudentServiceInterface {
    public StudentResponse addStudent(StudentRequest studentRequest);
    public List<StudentResponse> getAllStudent();
    public StudentResponse getById(String id);
    public StudentResponse update(String id, StudentRequest studentRequest);
    public void delete(String id);
}
