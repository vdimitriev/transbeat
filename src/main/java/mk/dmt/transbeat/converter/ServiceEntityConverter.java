package mk.dmt.transbeat.converter;

import mk.dmt.transbeat.entity.DisruptionEntity;
import mk.dmt.transbeat.entity.TransportServiceEntity;
import mk.dmt.transbeat.model.DisruptionDto;
import mk.dmt.transbeat.model.TransportServiceDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ServiceEntityConverter implements Converter<TransportServiceDto, TransportServiceEntity> {
    @Override
    public TransportServiceEntity convert(TransportServiceDto source) {
        return new TransportServiceEntity(
                null,
                source.getServiceRdtId(),
                source.getServiceType(),
                source.getServiceCompany(),
                source.getMaximumDelay(),
                source.getStopRdtId(),
                source.getStopStationCode(),
                source.getStopStationName()
        );
    }
}

