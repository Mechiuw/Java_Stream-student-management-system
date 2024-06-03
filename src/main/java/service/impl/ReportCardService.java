package service.impl;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import model.dto.request.ReportCardRequest;
import model.dto.response.ReportCardResponse;
import repository.ReportCardRepository;
import service.ReportCardServiceInterface;

import java.util.List;

@RequiredArgsConstructor
@Builder
public class ReportCardService implements ReportCardServiceInterface {
    private final ReportCardRepository repository;

    @Override
    public ReportCardResponse add(ReportCardRequest reportCardRequest) {
        return repository.create(reportCardRequest);
    }

    @Override
    public List<ReportCardResponse> getAll() {
        return repository.getAll();
    }

    @Override
    public ReportCardResponse getById(String id) {
        return repository.getById(id);
    }

    @Override
    public ReportCardResponse update(String id, ReportCardRequest reportCardRequest) {
        return repository.update(id,reportCardRequest);
    }

    @Override
    public void remove(String id) {
        repository.delete(id);
    }
}

