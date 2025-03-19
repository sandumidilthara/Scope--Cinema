package lk.ijse.backend.Service;

import jakarta.transaction.Transactional;
import lk.ijse.backend.DTO.FilmHallDTO;
import lk.ijse.backend.Entity.FilmHall;
import lk.ijse.backend.repo.FilmHallRepo;
import lk.ijse.backend.util.ImageUtil;
import org.hibernate.StaleObjectStateException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lk.ijse.backend.enums.ImageType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FilmHallServiceImpl implements FilmHallService {
    private static final Logger logger = LoggerFactory.getLogger(FilmHallServiceImpl.class);
    @Autowired
    private FilmHallRepo filmHallRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ImageUtil imageUtil;

    @Override
    @Transactional
    public FilmHallDTO<String> save(FilmHallDTO spiceDTO, MultipartFile file) {
        String base64Image = imageUtil.saveImage( ImageType.EXAMPLE,file);
        logger.info("Base64 image: {}", base64Image);
        FilmHall spice = modelMapper.map(spiceDTO, FilmHall.class);
        spice.setImageURL(base64Image);
        try {
            FilmHall savedSpice = filmHallRepo.save(spice);
            FilmHallDTO<String> stringSpiceDTO = modelMapper.map(savedSpice, FilmHallDTO.class);
            stringSpiceDTO.setImageURL(base64Image);
            return stringSpiceDTO;
        } catch (Exception e) {
            logger.error("Failed to save spice: {}", spice, e);
            throw new RuntimeException("Failed to save spice");
        }
    }

    @Override
    public List<FilmHallDTO<String>> getAll() {
        List<FilmHall> spices = filmHallRepo.findAll();
        List<FilmHallDTO<String>> spiceDTOS = modelMapper.map(spices, new TypeToken<List<FilmHallDTO<String>>>() {}.getType());
        for (FilmHallDTO<String> spiceDTO : spiceDTOS) {
            spices.stream().filter(spice ->
                            spice.getId().equals(spiceDTO.getId()))
                    .findFirst()
                    .ifPresent(spice -> spiceDTO.setImageURL(imageUtil.getImage(spice.getImageURL())));
        }
        return spiceDTOS;
    }



    @Override
    public void delete(UUID id) {
        if(filmHallRepo.existsById(id)){filmHallRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Film Hall does not exists");
        }
    }

    @Override
    public FilmHallDTO<String> update(UUID id, FilmHallDTO spiceDTO, MultipartFile file) {
        Optional<FilmHall> spice = filmHallRepo.findById(id);
        if (spice.isPresent()) {
            String imageName = spice.get().getImageURL();
            if (!file.isEmpty()) {
                imageName = imageUtil.updateImage(spice.get().getImageURL(), ImageType.FILMHALL, file);
            }
            spice.get().setImageURL(imageName);
            spice.get().setName(spiceDTO.getName());
            spice.get().setDescription(spiceDTO.getDescription());
            spice.get().setContactNumber(spiceDTO.getContactNumber());
            spice.get().setEmail(spiceDTO.getEmail());
            spice.get().setLocation(spiceDTO.getLocation());
            try {
                filmHallRepo.save(spice.get());
                logger.info("Spice updated successfully: {}", spice);
                return modelMapper.map(spice, FilmHallDTO.class);
            } catch (StaleObjectStateException e) {
                logger.error("Failed to update spice: {}", spice, e);
                throw new RuntimeException("Failed to update spice");
            }
        } else {
            logger.warn("Spice with id {} not found", id);
            throw new RuntimeException("Spice Listing Not Found");
        }
    }






}
