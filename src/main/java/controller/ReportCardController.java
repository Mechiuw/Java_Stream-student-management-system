package controller;

import lombok.RequiredArgsConstructor;
import model.dto.request.ReportCardRequest;
import model.dto.response.ReportCardResponse;
import service.ReportCardServiceInterface;

import java.util.List;

@RequiredArgsConstructor
public class ReportCardController {
    private final ReportCardServiceInterface reportCardServiceInterface;

    public ReportCardResponse create(ReportCardRequest reportCardRequest){
        return reportCardServiceInterface.add(reportCardRequest);
    }

    public ReportCardResponse getById(String id){
        return reportCardServiceInterface.getById(id);
    }

    public List<ReportCardResponse> getAll(){
        return reportCardServiceInterface.getAll();
    }

    public ReportCardResponse update(String id, ReportCardRequest reportCardRequest){
        return reportCardServiceInterface.update(id,reportCardRequest);
    }

    public void delete(String id){
        reportCardServiceInterface.remove(id);
    }
}
