package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.BookingDTO;
import lk.ijse.backend.DTO.FilmHallDTO;
import lk.ijse.backend.DTO.SeatTypeDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public interface BookingService {

    public  void save(BookingDTO seatTypeDTO);

    public ArrayList<BookingDTO> getAll();
    public void delete(Long id);
    public void update(BookingDTO seatTypeDTO);
}
