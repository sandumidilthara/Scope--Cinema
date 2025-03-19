package lk.ijse.backend.Controller;

import lk.ijse.backend.DTO.FilmRegistrationDTO;
import lk.ijse.backend.DTO.SeatTypeDTO;
import lk.ijse.backend.DTO.SeatsDTO;
import lk.ijse.backend.Service.FilmRegistrationService;
import lk.ijse.backend.Service.SeatService;
import lk.ijse.backend.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seat")
@CrossOrigin
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping(path = "save")
    public ResponceUtil getFilHall(@RequestBody SeatsDTO seatsDTO) {
       seatService.save(seatsDTO);
        return new ResponceUtil(201, "Film Hall is Saved", null);
    }

    @GetMapping("getAll")
    private ResponceUtil getAllFilmHall() {
        return new ResponceUtil(200, "success", seatService.getAll());
    }


    @PutMapping(path = "update")
    public  ResponceUtil update(@RequestBody SeatsDTO seatDTO){
         seatService.update(seatDTO);
        return new ResponceUtil( 201,"film hall is updated" ,null);

    }

        @DeleteMapping(path = "delete/{id}")
    public ResponceUtil deleteCustomer(@PathVariable(value = "id") Long id){
         seatService.delete(id);
        return new ResponceUtil(200,"film hall deleted" ,null);
    }

}
