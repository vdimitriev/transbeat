package mk.dmt.transbeat.service;

import lombok.RequiredArgsConstructor;
import mk.dmt.transbeat.converter.DisruptionEntityConverter;
import mk.dmt.transbeat.converter.ServiceEntityConverter;
import mk.dmt.transbeat.entity.DisruptionEntity;
import mk.dmt.transbeat.entity.TransportServiceEntity;
import mk.dmt.transbeat.helper.CSVHelper;
import mk.dmt.transbeat.model.DisruptionDto;
import mk.dmt.transbeat.model.TransportServiceDto;
import mk.dmt.transbeat.repository.DisruptionRepository;
import mk.dmt.transbeat.repository.TransportServiceRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConversionService {

    private final DisruptionRepository disruptionRepository;
    private final TransportServiceRepository transportServiceRepository;
    private final DisruptionEntityConverter disruptionEntityConverter;
    private final ServiceEntityConverter serviceEntityConverter;

    public void saveDisruptions(MultipartFile file) throws IOException {
        List<DisruptionDto> disruptions = CSVHelper.csvToDisruptions(file.getInputStream());
        for(DisruptionDto disruptionDto : disruptions) {
            DisruptionEntity disruptionEntity = disruptionEntityConverter.convert(disruptionDto);
            disruptionRepository.save(disruptionEntity);
        }
    }
    public void saveTransportServices(MultipartFile file) throws IOException {
        List<TransportServiceDto> transportServices = CSVHelper.csvToServices(file.getInputStream());
        for(TransportServiceDto dto : transportServices) {
            TransportServiceEntity entity = serviceEntityConverter.convert(dto);
            transportServiceRepository.save(entity);
        }
    }
}
