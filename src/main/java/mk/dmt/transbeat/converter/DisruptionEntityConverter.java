package mk.dmt.transbeat.converter;

import mk.dmt.transbeat.entity.DisruptionEntity;
import mk.dmt.transbeat.model.DisruptionDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class DisruptionEntityConverter implements Converter<DisruptionDto, DisruptionEntity>  {
    @Override
    public DisruptionEntity convert(DisruptionDto source) {
        return new DisruptionEntity(
                null,
                source.getRdtId(),
                source.getCauseNl(),
                source.getCauseEn(),
                source.getDurationMinutes()
        );
    }
}
