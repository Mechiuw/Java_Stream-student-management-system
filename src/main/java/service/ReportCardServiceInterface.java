package service;

import model.dto.request.ReportCardRequest;
import model.dto.response.ReportCardResponse;

import java.util.List;

public interface ReportCardServiceInterface {
    ReportCardResponse add(ReportCardRequest reportCardRequest);
    List<ReportCardResponse> getAll();
    ReportCardResponse getById(String id);
    ReportCardResponse update(String id, ReportCardRequest reportCardRequest);
    void remove(String id);
}
