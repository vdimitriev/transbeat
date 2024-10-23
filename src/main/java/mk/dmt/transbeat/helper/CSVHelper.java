package mk.dmt.transbeat.helper;

import mk.dmt.transbeat.model.DisruptionDto;
import mk.dmt.transbeat.model.TransportServiceDto;
import org.apache.commons.csv.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {
  public static String TYPE = "text/csv";
  static String[] HEADERs = { "Id", "Title", "Description", "Published" };

  public static boolean hasCSVFormat(MultipartFile file) {

    if (!TYPE.equals(file.getContentType())) {
      return false;
    }

    return true;
  }

  public static List<DisruptionDto> csvToDisruptions(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<DisruptionDto> disruptions = new ArrayList<DisruptionDto>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        DisruptionDto disruption = new DisruptionDto(
              Long.parseLong(csvRecord.get("rdt_id")),
              csvRecord.get("cause_nl"),
              csvRecord.get("cause_en"),
              Integer.parseInt(csvRecord.get("duration_minutes"))
            );
        disruptions.add(disruption);
      }

      return disruptions;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

  public static List<TransportServiceDto> csvToServices(InputStream is) {
    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        CSVParser csvParser = new CSVParser(fileReader,
            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

      List<TransportServiceDto> transportServices = new ArrayList<TransportServiceDto>();

      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

      for (CSVRecord csvRecord : csvRecords) {
        TransportServiceDto disruption = new TransportServiceDto(
              Long.parseLong(csvRecord.get("Service:RDT-ID")),
              csvRecord.get("Service:Type"),
              csvRecord.get("Service:Company"),
              Integer.parseInt(csvRecord.get("Service:Maximum delay")),
              Long.parseLong(csvRecord.get("Stop:RDT-ID")),
              csvRecord.get("Stop:Station code"),
              csvRecord.get("Stop:Station name")
            );
        transportServices.add(disruption);
      }
      return transportServices;
    } catch (IOException e) {
      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
    }
  }

}
