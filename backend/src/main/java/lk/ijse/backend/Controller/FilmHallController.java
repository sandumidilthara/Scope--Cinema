package lk.ijse.backend.Controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import lk.ijse.backend.DTO.FilmHallDTO;
import lk.ijse.backend.Service.FilmHallServiceImpl;
import lk.ijse.backend.util.ResponceUtil;
import lk.ijse.backend.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/example")
@CrossOrigin
public class FilmHallController {


    private  static final Logger log = LoggerFactory.getLogger(FilmHallController.class);
    @Autowired
    private FilmHallServiceImpl spiceService;
    @PostMapping(value = "/save", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveSpice(@RequestPart("spice") String spiceJson, @RequestPart("file") MultipartFile file) {
        try {
            FilmHallDTO spiceDTO = new ObjectMapper().readValue(spiceJson, FilmHallDTO.class);
            log.info("Received request to save spice: {}", spiceDTO.getName());
            spiceDTO.setImageURL(file.getOriginalFilename());
            FilmHallDTO<String> savedSpice = spiceService.save(spiceDTO, file);
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
            List<FilmHallDTO<String>> spices = spiceService.getAll();
            return new ResponseUtil(201, "Spices retrieved successfully", spices);
        } catch (Exception e) {
            log.error("Error retrieving spices", e);
            return new ResponseUtil(500, "Internal server error", null);
        }
    }



    @DeleteMapping(path = "delete/{id}")
    public ResponceUtil deleteCustomer(@PathVariable(value = "id") UUID id){
        spiceService.delete(id);
        return new ResponceUtil(200,"film hall deleted" ,null);
    }








    @PutMapping(path = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateSpiceListening(@RequestPart("spice") String spiceJson, @RequestPart("file") MultipartFile file) {
        try {
            FilmHallDTO spiceDTO = new ObjectMapper().readValue(spiceJson, FilmHallDTO.class);
            log.info("Received request to update spice: {}", spiceDTO.getName());
            spiceDTO.setImageURL(file.getOriginalFilename());
            FilmHallDTO<String> updatedSpice = spiceService.update(spiceDTO.getId(), spiceDTO, file);
            log.info("Spice updated successfully: {}", spiceDTO.getName());
            return new ResponseUtil(201, "Spice updated successfully", updatedSpice);
        } catch (Exception e) {
            log.error("Error updating spice", e);
            return new ResponseUtil(500, "Internal server error", null);
        }
    }






    }
