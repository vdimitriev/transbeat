//package mk.dmt.transbeat.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.util.List;
//
//@Service
//public class CSVService {
//  @Autowired
//  TutorialRepository repository;
//
//  public void save(MultipartFile file) {
//    try {
//      List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
//      repository.saveAll(tutorials);
//    } catch (IOException e) {
//      throw new RuntimeException("fail to store csv data: " + e.getMessage());
//    }
//  }
//
//  public ByteArrayInputStream load() {
//    List<Tutorial> tutorials = repository.findAll();
//
//    ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
//    return in;
//  }
//
//  public List<Tutorial> getAllTutorials() {
//    return repository.findAll();
//  }
//}
