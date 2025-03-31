package lk.ijse.backend.Service;

import jakarta.transaction.Transactional;
import lk.ijse.backend.DTO.BookingDTO;
import lk.ijse.backend.DTO.TimeTableDTO;
import lk.ijse.backend.Entity.Booking;
import lk.ijse.backend.Entity.TimeTable;
import lk.ijse.backend.repo.BookingRepo;
import lk.ijse.backend.repo.TimeTableRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookingServiceImpl implements BookingService{



    @Autowired
    private BookingRepo timeTableRepo;

    @Autowired
    private ModelMapper modelMapper;
@Transactional
    @Override
    public void save(BookingDTO timeTableDTO) {

        if(timeTableRepo.existsById(timeTableDTO.getId()))  {throw new RuntimeException("Fill Hall Already exists");}
        timeTableRepo.save(modelMapper.map(timeTableDTO, Booking.class));
    }

    @Override
    public ArrayList<BookingDTO> getAll() {
        return modelMapper.map(timeTableRepo.findAll(),new TypeToken<List<BookingDTO>>() {}.getType());
    }

    @Override
    public void delete(Long id) {
        if(timeTableRepo.existsById(id)){timeTableRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Film Hall does not exists");
        }
    }

    @Override
    public void update(BookingDTO timeTableDTO) {
        if(timeTableRepo.existsById(timeTableDTO.getId())){
            timeTableRepo.save(modelMapper.map(timeTableDTO,Booking.class));
        }

        else {

            throw new RuntimeException("customer does not exists");
        }


    }
}
