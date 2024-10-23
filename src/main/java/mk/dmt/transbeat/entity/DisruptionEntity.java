package mk.dmt.transbeat.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "disruption")
public class DisruptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "rdt_id")
    private Long rdtId;

    @Column(name = "cause_nl")
    private String causeNl;

    @Column(name = "cause_en")
    private String causeEn;

    @Column(name = "duration_minutes")
    private Integer durationMinutes;

}
