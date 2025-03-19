package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.FilmRegistrationDTO;
import lk.ijse.backend.DTO.TimeTableDTO;
import lk.ijse.backend.Entity.FilmHall;
import lk.ijse.backend.Entity.FilmRegistration;
import lk.ijse.backend.Entity.TimeTable;
import lk.ijse.backend.repo.FilmRegistrationRepo;
import lk.ijse.backend.repo.TimeTableRepo;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FilmRegistrationImpl implements FilmRegistrationService{


    @Autowired
    private FilmRegistrationRepo filmRegistrationRepo;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public void save(FilmRegistrationDTO filmRegistrationDTO) {




            if( filmRegistrationRepo.existsById(filmRegistrationDTO.getId()))  {throw new RuntimeException("Fill Hall Already exists");}
             filmRegistrationRepo.save(modelMapper.map(filmRegistrationDTO, FilmRegistration.class));

    }



    @Override
    public ArrayList<Map<String, Object>> getAll() {
        List<FilmRegistration> filmRegistrations = filmRegistrationRepo.findAll();
        ArrayList<Map<String, Object>> result = new ArrayList<>();

        for (FilmRegistration registration : filmRegistrations) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", registration.getId());
            item.put("hallName", registration.getFilmHall().getName());
            item.put("filmTitle", registration.getFilm().getTitle());
            item.put("timeDescription", registration.getTimeTable().getDescription());

            result.add(item);
        }

        return result;
    }





    public void delete(Long id) {
        if (filmRegistrationRepo.existsById(id)) {
            filmRegistrationRepo.deleteFilmRegistrationById(id);
        } else {
            throw new RuntimeException("Film registration does not exist");
        }




        }
    }

