package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.TimeTableDTO;

import java.util.ArrayList;

public interface TimeTableService {


    public  void save(TimeTableDTO timeTableDTO);

    public ArrayList<TimeTableDTO> getAll();
    public void delete(Long id);
    public void update( TimeTableDTO  timeTableDTO);
}
