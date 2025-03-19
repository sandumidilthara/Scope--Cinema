package lk.ijse.backend.Controller;

import lk.ijse.backend.DTO.SeatTypeDTO;
import lk.ijse.backend.DTO.TimeTableDTO;
import lk.ijse.backend.Service.SeatTypeService;
import lk.ijse.backend.Service.TimeTableService;
import lk.ijse.backend.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seat-type")
@CrossOrigin
public class SeatTypeController {


    @Autowired
    private SeatTypeService seatTypeService;


    @PostMapping(path = "save" )
    public ResponceUtil getFilHall(@RequestBody SeatTypeDTO seatTypeDTO){
         seatTypeService.save(seatTypeDTO);
        return new ResponceUtil( 201,"Film Hall is Saved" ,null);
    }


    @GetMapping("getAll")
    private ResponceUtil getAllFilmHall(){
        return  new ResponceUtil(200,"success", seatTypeService.getAll());
    }


    @DeleteMapping(path = "delete/{id}")
    public ResponceUtil deleteCustomer(@PathVariable(value = "id") Long id){
        seatTypeService.delete(id);
        return new ResponceUtil(200,"film hall deleted" ,null);
    }





    @PutMapping(path = "update")
    public  ResponceUtil update(@RequestBody  SeatTypeDTO seatTypeDTO){
         seatTypeService.update(seatTypeDTO);
        return new ResponceUtil( 201,"film hall is updated" ,null);

    }



}
