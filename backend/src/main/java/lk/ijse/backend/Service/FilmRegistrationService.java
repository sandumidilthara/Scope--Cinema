package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.FilmRegistrationDTO;
import lk.ijse.backend.DTO.TimeTableDTO;

import java.util.ArrayList;
import java.util.Map;

public interface FilmRegistrationService {

    public  void save(FilmRegistrationDTO filmRegistrationDTO);
    //public ArrayList<FilmRegistrationDTO> getAll();
    public ArrayList<Map<String, Object>> getAll();

    public void delete(Long id);
}
