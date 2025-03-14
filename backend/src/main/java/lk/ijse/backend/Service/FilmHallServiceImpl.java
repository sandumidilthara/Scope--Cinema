package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.FilmHallDTO;
import lk.ijse.backend.Entity.FilmHall;
import lk.ijse.backend.repo.FilmHallRepo;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class FilmHallServiceImpl  implements FilmHallService{

    @Autowired
    private FilmHallRepo filmHallRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void save(FilmHallDTO filmHallDTO)  {


        if(filmHallRepo.existsById(filmHallDTO.getId()))  {throw new RuntimeException("Fill Hall Already exists");}
         filmHallRepo.save(modelMapper.map(filmHallDTO, FilmHall.class));

    }

    @Override
    public ArrayList<FilmHallDTO> getAll() {
        return modelMapper.map(filmHallRepo.findAll(),new TypeToken<List<FilmHallDTO>>() {}.getType());
    }

    @Override
    public void delete(Long id) {
        if(filmHallRepo.existsById(id)){filmHallRepo.deleteById(id);
        }
else {
            throw new RuntimeException("Film Hall does not exists");
        }
    }

    @Override
    public void update(FilmHallDTO filmHallDTO) {
        if(filmHallRepo.existsById(filmHallDTO.getId())){
            filmHallRepo.save(modelMapper.map(filmHallDTO,FilmHall.class));
        }

else {

            throw new RuntimeException("customer does not exists");
        }

    }
}






















