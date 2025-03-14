package lk.ijse.backend.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.backend.DTO.ExampleDTO;
import lk.ijse.backend.Service.ExampleServiceImpl;
import lk.ijse.backend.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/v1/example")
@CrossOrigin
public class ExampleController {


    private  static final Logger log = LoggerFactory.getLogger(ExampleController.class);
    @Autowired
    private ExampleServiceImpl spiceService;
    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveSpice(@RequestPart("spice") String spiceJson, @RequestPart("file") MultipartFile file) {
        try {
            ExampleDTO spiceDTO = new ObjectMapper().readValue(spiceJson, ExampleDTO.class);
            log.info("Received request to save spice: {}", spiceDTO.getName());
            spiceDTO.setImageURL(file.getOriginalFilename());
            ExampleDTO<String> savedSpice = spiceService.save(spiceDTO, file);
            log.info("Spice saved successfully: {}", spiceDTO.getName());
            return new ResponseUtil(201, "Spice saved successfully", savedSpice);
        } catch (Exception e) {
            log.error("Error saving spice", e);
            return new ResponseUtil(500, "Internal server error", null);
        }
    }
    @GetMapping(path = "/get")
    public ResponseUtil getAllSpiceListenings(){
        try {
            List<ExampleDTO<String>> spices = spiceService.getAll();
            return new ResponseUtil(201, "Spices retrieved successfully", spices);
        } catch (Exception e) {
            log.error("Error retrieving spices", e);
            return new ResponseUtil(500, "Internal server error", null);
        }
    }
}
