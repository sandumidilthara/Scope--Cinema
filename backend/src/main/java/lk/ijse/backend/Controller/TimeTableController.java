package lk.ijse.backend.Controller;

import lk.ijse.backend.DTO.TimeTableDTO;
import lk.ijse.backend.Service.TimeTableService;
import lk.ijse.backend.util.ResponceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/time-table")
@CrossOrigin
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;


    @PostMapping(path = "save" )
    public ResponceUtil getFilHall(@RequestBody TimeTableDTO timeTableDTO){
         timeTableService.save(timeTableDTO);
        return new ResponceUtil( 201,"Film Hall is Saved" ,null);
    }


    @GetMapping("getAll")
    private ResponceUtil getAllFilmHall(){
        return  new ResponceUtil(200,"success",timeTableService.getAll());
    }


    @DeleteMapping(path = "delete/{id}")
    public ResponceUtil deleteCustomer(@PathVariable(value = "id") Long id){
        timeTableService.delete(id);
        return new ResponceUtil(200,"film hall deleted" ,null);
    }





    @PutMapping(path = "update")
    public  ResponceUtil update(@RequestBody TimeTableDTO timeTableDTO){
      timeTableService.update(timeTableDTO);
        return new ResponceUtil( 201,"film hall is updated" ,null);

    }





}
