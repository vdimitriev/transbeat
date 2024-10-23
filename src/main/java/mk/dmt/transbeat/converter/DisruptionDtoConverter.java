package mk.dmt.transbeat.converter;

import mk.dmt.transbeat.entity.DisruptionEntity;
import mk.dmt.transbeat.model.DisruptionDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DisruptionDtoConverter implements Converter<DisruptionEntity, DisruptionDto> {
    @Override
    public DisruptionDto convert(DisruptionEntity source) {
        return new DisruptionDto(
                source.getRdtId(),
                source.getCauseNl(),
                source.getCauseEn(),
                source.getDurationMinutes()
        );
    }
}