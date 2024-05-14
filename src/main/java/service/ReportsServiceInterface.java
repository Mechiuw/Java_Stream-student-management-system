package service;

import model.dto.request.ReportsRequest;
import model.dto.response.ReportsResponse;

import java.util.List;

public interface ReportsServiceInterface {
    public ReportsResponse addReports(ReportsRequest reportsRequest);
    public List<ReportsResponse> getAllReports();
    public ReportsResponse getById(String id);
    public ReportsResponse updateReports(String id, ReportsRequest reportsRequest);
    public void removeReports(String id);
}
