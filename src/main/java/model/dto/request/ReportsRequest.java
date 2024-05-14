package model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ReportsRequest {
    private String subject;
    private String unit;
    private Integer semester;
    private String year;
}
