package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.UpcomingFilmDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

public interface UpcomingFilmService {



    UpcomingFilmDTO <String> save( UpcomingFilmDTO spiceDTO, MultipartFile file);
    List<UpcomingFilmDTO<String>> getAll();

    public void delete(UUID id);



    public UpcomingFilmDTO<String> update(UUID id, UpcomingFilmDTO spiceDTO, MultipartFile file);
}
