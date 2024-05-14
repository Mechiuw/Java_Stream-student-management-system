package service.impl;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import model.dto.request.ReportsRequest;
import model.dto.response.ReportsResponse;
import repository.ReportsRepository;
import service.ReportsServiceInterface;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class ReportsService implements ReportsServiceInterface {
    private final ReportsRepository repository;
    public ReportsResponse addReports(ReportsRequest reportsRequest){
        return repository.post(reportsRequest);
    }

    public List<ReportsResponse> getAllReports(){
        return repository.getAll();
    }

    @Override
    public ReportsResponse getById(String id) {
        return repository.getById(id);
    }

    @Override
    public ReportsResponse updateReports(String id, ReportsRequest reportsRequest) {
        return repository.update(id,reportsRequest);
    }

    @Override
    public void removeReports(String id) {
        repository.delete(id);
    }
}
