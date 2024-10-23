package mk.dmt.transbeat.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransportServiceDto {

    private Long serviceRdtId;
    private String serviceType;
    private String serviceCompany;
    private Integer maximumDelay;
    private Long stopRdtId;
    private String stopStationCode;
    private String stopStationName;

}
