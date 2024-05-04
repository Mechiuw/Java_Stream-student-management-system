package service;

import lombok.*;
import model.dto.request.StudentRequest;
import model.dto.response.StudentResponse;
import repository.StudentRepository;

import java.util.List;


@RequiredArgsConstructor
@Builder
@Setter
@Getter
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentResponse addStudent(StudentRequest studentRequest){
        return studentRepository.post(studentRequest);
    }

    public List<StudentResponse> getAllStudent(){
        return studentRepository.getAll();
    }

    public StudentResponse getById(String id){
        return studentRepository.getById(id);
    }

    public StudentResponse update(String id, StudentRequest studentRequest){
        return studentRepository.update(id,studentRequest);
    }

    public void delete(String id){
        studentRepository.delete(id);
    }
}
