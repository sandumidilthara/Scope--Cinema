package lk.ijse.backend.Controller;
import lk.ijse.backend.DTO.FilmHallDTO;
import lk.ijse.backend.Service.FilmHallService;
import lk.ijse.backend.Service.FilmHallServiceImpl;
import lk.ijse.backend.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/film-hall")
@CrossOrigin
public class FilmHallController {


    @Autowired
    private FilmHallService filmHallService;


    @PostMapping  (path = "save" )
    public ResponceUtil getFilHall(@ModelAttribute FilmHallDTO filmHallDTO ){
         filmHallService.save(filmHallDTO);
        return new ResponceUtil( 201,"Film Hall is Saved" ,null);
    }


    @GetMapping("getAll")
    private ResponceUtil getAllFilmHall(){
        return  new ResponceUtil(200,"success",filmHallService.getAll());
    }


    @DeleteMapping(path = "delete/{id}")
    public ResponceUtil deleteCustomer(@PathVariable(value = "id") Long id){
        filmHallService.delete(id);
        return new ResponceUtil(200,"film hall deleted" ,null);
    }





    @PutMapping(path = "update")
    public  ResponceUtil update(@ModelAttribute FilmHallDTO filmHallDTO){
      filmHallService.update(filmHallDTO);
        return new ResponceUtil( 201,"film hall is updated" ,null);

    }

}