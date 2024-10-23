package mk.dmt.transbeat.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisruptionDto {

    private Long rdtId;
    private String causeNl;
    private String causeEn;
    private Integer durationMinutes;

}
