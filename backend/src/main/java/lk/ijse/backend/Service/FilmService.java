package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.FilmDTO;
import lk.ijse.backend.DTO.FilmHallDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface FilmService {


    FilmDTO<String> save(FilmDTO spiceDTO, MultipartFile file);
    List<FilmDTO<String>> getAll();

    public void delete(UUID id);

    public FilmDTO<String> getFilmImage(UUID filmId);


   public FilmDTO<String> update(UUID id, FilmDTO spiceDTO, MultipartFile file);

}
