package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.FilmRegistrationDTO;
import lk.ijse.backend.DTO.SeatsDTO;

import java.util.ArrayList;
import java.util.Map;

public interface SeatService {

    public  void save(SeatsDTO seatsDTO);

    public ArrayList<Map<String, Object>> getAll();
    public void delete(Long id);
    public void update(SeatsDTO seatDTO);
}
