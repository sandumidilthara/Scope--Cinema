package lk.ijse.backend.Controller;

import lk.ijse.backend.DTO.FilmRegistrationDTO;
import lk.ijse.backend.DTO.TimeTableDTO;
import lk.ijse.backend.Service.FilmRegistrationService;
import lk.ijse.backend.Service.TimeTableService;
import lk.ijse.backend.util.KUtil;
import lk.ijse.backend.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/film-registration")
@CrossOrigin
public class FilmRegistrationController {


    @Autowired
    private FilmRegistrationService filmRegistrationService;


    @PostMapping(path = "save")
    public ResponceUtil getFilHall(@RequestBody FilmRegistrationDTO filmRegistrationDTO) {
        filmRegistrationService.save(filmRegistrationDTO);
        return new ResponceUtil(201, "Film Hall is Saved", null);
    }

    @GetMapping("getAll")
    private ResponceUtil getAllFilmHall() {
        return new ResponceUtil(200, "success", filmRegistrationService.getAll());
    }


//    @DeleteMapping(path = "delete/{id}")
//    public ResponceUtil deleteCustomer(@PathVariable(value = "id") Long id){
//         filmRegistrationService.delete(id);
//        return new ResponceUtil(200,"film hall deleted" ,null);
//    }


    @DeleteMapping(path = "delete/{id}")
    public ResponceUtil deleteCustomer(@PathVariable(value = "id") Long id) {
        try {
            filmRegistrationService.delete(id);
            return new ResponceUtil(200, "Film registration deleted", null);
        } catch (RuntimeException e) {
            return new ResponceUtil(400, e.getMessage(), null);
        }
    }



}



