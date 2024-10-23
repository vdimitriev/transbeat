package mk.dmt.transbeat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transport_service")
public class TransportServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "service_rdt_id")
    private Long serviceRdtId;

    @Column(name = "service_type")
    private String serviceType;

    @Column(name = "service_company")
    private String serviceCompany;

    @Column(name = "maximum_delay")
    private Integer maximumDelay;

    @Column(name = "stop_rdt_id")
    private Long stopRdtId;

    @Column(name = "stop_station_code")
    private String stopStationCode;

    @Column(name = "stop_station_name")
    private String stopStationName;

}
