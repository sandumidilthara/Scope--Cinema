package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.SeatTypeDTO;
import lk.ijse.backend.DTO.TimeTableDTO;

import java.util.ArrayList;

public interface SeatTypeService {


    public  void save(SeatTypeDTO seatTypeDTO);

    public ArrayList<SeatTypeDTO> getAll();
    public void delete(Long id);
    public void update(SeatTypeDTO seatTypeDTO);
}
