package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.SeatTypeDTO;
import lk.ijse.backend.DTO.TimeTableDTO;
import lk.ijse.backend.Entity.SeatType;
import lk.ijse.backend.Entity.TimeTable;
import lk.ijse.backend.repo.SeatTypeRepo;
import lk.ijse.backend.repo.TimeTableRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SeatTypeServiceImpl implements SeatTypeService{



    @Autowired
    private SeatTypeRepo seatTypeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(SeatTypeDTO seatTypeDTO) {

        if( seatTypeRepo.existsById( seatTypeDTO.getId()))  {throw new RuntimeException("Fill Hall Already exists");}
         seatTypeRepo.save(modelMapper.map(seatTypeDTO, SeatType.class));
    }

    @Override
    public ArrayList<SeatTypeDTO> getAll() {
        return modelMapper.map(seatTypeRepo.findAll(),new TypeToken<List<SeatTypeDTO>>() {}.getType());
    }

    @Override
    public void delete(Long id) {
        if(seatTypeRepo.existsById(id)){seatTypeRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Film Hall does not exists");
        }
    }

    @Override
    public void update(SeatTypeDTO seatTypeDTO) {
        if(seatTypeRepo.existsById(seatTypeDTO.getId())){
            seatTypeRepo.save(modelMapper.map(seatTypeDTO,SeatType.class));
        }

        else {

            throw new RuntimeException("customer does not exists");
        }


    }
}
