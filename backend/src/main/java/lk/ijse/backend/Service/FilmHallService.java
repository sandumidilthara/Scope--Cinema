package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.FilmHallDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface FilmHallService {

    FilmHallDTO<String> save(FilmHallDTO spiceDTO, MultipartFile file);
    List<FilmHallDTO<String>> getAll();

    public void delete(UUID id);



    public FilmHallDTO<String> update(UUID id, FilmHallDTO spiceDTO, MultipartFile file);

}
