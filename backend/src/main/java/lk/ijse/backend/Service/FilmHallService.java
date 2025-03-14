package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.FilmHallDTO;

import java.util.ArrayList;

public interface FilmHallService {


    public  void save(FilmHallDTO filmHallDTO);

    public ArrayList<FilmHallDTO> getAll();
    public void delete(Long id);
    public void update(FilmHallDTO filmHallDTO);
}
