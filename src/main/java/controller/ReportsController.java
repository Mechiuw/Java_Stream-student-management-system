package controller;

import lombok.RequiredArgsConstructor;
import model.dto.request.ReportsRequest;
import model.dto.response.ReportsResponse;
import service.ReportsServiceInterface;

import java.util.List;

@RequiredArgsConstructor
public class ReportsController {
    private final ReportsServiceInterface reportsService;

    public ReportsResponse createReports(ReportsRequest reportsRequest){
        return reportsService.addReports(reportsRequest);
    }
    public List<ReportsResponse> viewAllReports(){
        return reportsService.getAllReports();
    }
    public ReportsResponse viewById(String id){
        return reportsService.getById(id);
    }
    public ReportsResponse updateReports(String id, ReportsRequest request){
        return reportsService.updateReports(id,request);
    }

    public void deleteReports(String id){
        reportsService.removeReports(id);
    }
}
