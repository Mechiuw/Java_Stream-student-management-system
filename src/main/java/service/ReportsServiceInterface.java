package service;

import model.dto.request.ReportCardRequest;
import model.dto.request.ReportsRequest;
import model.dto.response.ReportCardResponse;
import model.dto.response.ReportsResponse;

import java.util.List;

public interface ReportsServiceInterface {
    ReportsResponse addReports(ReportsRequest reportsRequest);

    ReportCardResponse add(ReportCardRequest reportCardRequest);

    List<ReportsResponse> getAllReports();
    ReportsResponse getById(String id);
    ReportsResponse updateReports(String id, ReportsRequest reportsRequest);
    void removeReports(String id);
}
