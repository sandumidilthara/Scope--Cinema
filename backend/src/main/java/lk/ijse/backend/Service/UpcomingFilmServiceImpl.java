package lk.ijse.backend.Service;

import jakarta.transaction.Transactional;
import lk.ijse.backend.DTO.UpcomingFilmDTO;
import lk.ijse.backend.Entity.UpcomingFilm;
import lk.ijse.backend.enums.ImageType;
import lk.ijse.backend.repo.UpcomingFilmRepo;
import lk.ijse.backend.util.ImageUtil;
import org.hibernate.StaleObjectStateException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class UpcomingFilmServiceImpl implements UpcomingFilmService {

    private static final Logger logger = LoggerFactory.getLogger(FilmServiceImpl.class);

    @Autowired
    private UpcomingFilmRepo filmRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ImageUtil imageUtil;

    @Override
    @Transactional
    public UpcomingFilmDTO<String> save(UpcomingFilmDTO filmDTO, MultipartFile file) {
        String base64Image;
        try {
            base64Image = imageUtil.saveImage(ImageType.UPFILM, file);
            logger.info("Base64 image: {}", base64Image);
        } catch (Exception e) {
            logger.error("Failed to save image", e);
            throw new RuntimeException("Failed to save image: " + e.getMessage());
        }

        UpcomingFilm film = modelMapper.map(filmDTO, UpcomingFilm.class);
        film.setImageUrl(base64Image);
        try {
            UpcomingFilm savedFilm = filmRepo.save(film);
            UpcomingFilmDTO<String> stringFilmDTO = modelMapper.map(savedFilm, UpcomingFilmDTO.class);
            stringFilmDTO.setImageUrl(base64Image);
            return stringFilmDTO;
        } catch (Exception e) {
            logger.error("Failed to save film: {}", film, e);
            throw new RuntimeException("Failed to save film: " + e.getMessage());
        }
    }

    @Override
    public List<UpcomingFilmDTO<String>> getAll() {
        List<UpcomingFilm> films = filmRepo.findAll();
        List<UpcomingFilmDTO<String>> filmDTOs = modelMapper.map(films, new TypeToken<List<UpcomingFilmDTO<String>>>() {}.getType());
        for (UpcomingFilmDTO<String> filmDTO : filmDTOs) {
            films.stream().filter(film ->
                            film.getId().equals(filmDTO.getId()))
                    .findFirst()
                    .ifPresent(film -> filmDTO.setImageUrl(imageUtil.getImage(film.getImageUrl())));
        }
        return filmDTOs;
    }

    @Override
    public void delete(UUID id) {
        if(filmRepo.existsById(id)){filmRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Film Hall does not exists");
        }
    }

    @Override
    public UpcomingFilmDTO<String> update(UUID id, UpcomingFilmDTO spiceDTO, MultipartFile file) {
        Optional<UpcomingFilm> spice = filmRepo.findById(id);
        if (spice.isPresent()) {
            String imageName = spice.get().getImageUrl();
            if (!file.isEmpty()) {
                imageName = imageUtil.updateImage(spice.get().getImageUrl(), ImageType.UPFILM, file);
            }
            spice.get().setImageUrl(imageName);
            spice.get().setTitle(spiceDTO.getTitle());
            spice.get().setDescription(spiceDTO.getDescription());
            spice.get().setGenre(spiceDTO.getGenre());
            spice.get().setTeam(spiceDTO.getTeam());


            spice.get().setDurationMinutes(spiceDTO.getDurationMinutes());

            spice.get().setReleaseDate(spiceDTO.getReleaseDate());
            spice.get().setLanguage(spiceDTO.getLanguage());
            spice.get().setCast(spiceDTO.getCast());
            spice.get().setTrailerUrl(spiceDTO.getTrailerUrl());
            try {
                filmRepo.save(spice.get());
                logger.info("Spice updated successfully: {}", spice);
                return modelMapper.map(spice, UpcomingFilmDTO.class);
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

