package model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class ReportsResponse {
    private String subject;
    private String unit;
    private Integer semester;
    private String year;
}
