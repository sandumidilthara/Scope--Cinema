package lk.ijse.backend.Service;

import jakarta.transaction.Transactional;
import lk.ijse.backend.DTO.FilmDTO;
import lk.ijse.backend.DTO.FilmHallDTO;
import lk.ijse.backend.Entity.Film;
import lk.ijse.backend.Entity.FilmHall;
import lk.ijse.backend.enums.ImageType;
import lk.ijse.backend.repo.FilmHallRepo;
import lk.ijse.backend.repo.FilmRepo;
import lk.ijse.backend.util.ImageUtil;
import org.hibernate.StaleObjectStateException;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class FilmServiceImpl implements FilmService {


//
//    private static final Logger logger = LoggerFactory.getLogger(FilmServiceImpl.class);
//    @Autowired
//    private FilmRepo filmRepo;
//    @Autowired
//    private ModelMapper modelMapper;
//    @Autowired
//    private ImageUtil imageUtil;

//    @Override
//    @Transactional
//    public FilmDTO<String> save(FilmDTO spiceDTO, MultipartFile file) {
//        String base64Image = imageUtil.saveImage( ImageType.FILM,file);
//        logger.info("Base64 image: {}", base64Image);
//        Film spice = modelMapper.map(spiceDTO, Film.class);
//        spice.setImageUrl(base64Image);
//        try {
//            Film savedSpice = filmRepo.save(spice);
//            FilmDTO<String> stringSpiceDTO = modelMapper.map(savedSpice, FilmDTO.class);
//            stringSpiceDTO.setImageUrl(base64Image);
//            return stringSpiceDTO;
//        } catch (Exception e) {
//            logger.error("Failed to save spice: {}", spice, e);
//            throw new RuntimeException("Failed to save spice");
//        }
//    }
//
//
//    @Override
//    public List<FilmDTO<String>> getAll() {
//        List<Film> spices = filmRepo.findAll();
//        List<FilmDTO<String>> spiceDTOS = modelMapper.map(spices, new TypeToken<List<FilmDTO<String>>>() {}.getType());
//        for (FilmDTO<String> spiceDTO : spiceDTOS) {
//            spices.stream().filter(spice ->
//                            spice.getId().equals(spiceDTO.getId()))
//                    .findFirst()
//                    .ifPresent(spice -> spiceDTO.setImageUrl(imageUtil.getImage(spice.getImageUrl())));
//        }
//        return spiceDTOS;
//    }


    private static final Logger logger = LoggerFactory.getLogger(FilmServiceImpl.class);

    @Autowired
    private FilmRepo filmRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ImageUtil imageUtil;

    @Override
    @Transactional
    public FilmDTO<String> save(FilmDTO filmDTO, MultipartFile file) {
        String base64Image;
        try {
            base64Image = imageUtil.saveImage(ImageType.FILM, file);
            logger.info("Base64 image: {}", base64Image);
        } catch (Exception e) {
            logger.error("Failed to save image", e);
            throw new RuntimeException("Failed to save image: " + e.getMessage());
        }

        Film film = modelMapper.map(filmDTO, Film.class);
        film.setImageUrl(base64Image);
        try {
            Film savedFilm = filmRepo.save(film);
            FilmDTO<String> stringFilmDTO = modelMapper.map(savedFilm, FilmDTO.class);
            stringFilmDTO.setImageUrl(base64Image);
            return stringFilmDTO;
        } catch (Exception e) {
            logger.error("Failed to save film: {}", film, e);
            throw new RuntimeException("Failed to save film: " + e.getMessage());
        }
    }

    @Override
    public List<FilmDTO<String>> getAll() {
        List<Film> films = filmRepo.findAll();
        List<FilmDTO<String>> filmDTOs = modelMapper.map(films, new TypeToken<List<FilmDTO<String>>>() {
        }.getType());
        for (FilmDTO<String> filmDTO : filmDTOs) {
            films.stream().filter(film ->
                            film.getId().equals(filmDTO.getId()))
                    .findFirst()
                    .ifPresent(film -> filmDTO.setImageUrl(imageUtil.getImage(film.getImageUrl())));
        }
        return filmDTOs;
    }

    @Override
    public void delete(UUID id) {
        if (filmRepo.existsById(id)) {
            filmRepo.deleteById(id);
        } else {
            throw new RuntimeException("Film Hall does not exists");
        }
    }

    @Override
    public FilmDTO<String> update(UUID id, FilmDTO spiceDTO, MultipartFile file) {
        Optional<Film> spice = filmRepo.findById(id);
        if (spice.isPresent()) {
            String imageName = spice.get().getImageUrl();
            if (!file.isEmpty()) {
                imageName = imageUtil.updateImage(spice.get().getImageUrl(), ImageType.FILM, file);
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
                return modelMapper.map(spice, FilmDTO.class);
            } catch (StaleObjectStateException e) {
                logger.error("Failed to update spice: {}", spice, e);
                throw new RuntimeException("Failed to update spice");
            }
        } else {
            logger.warn("Spice with id {} not found", id);
            throw new RuntimeException("Spice Listing Not Found");
        }
    }






    public FilmDTO<String> getFilmImage(UUID filmId) {
        Optional<Film> filmOptional = filmRepo.findById(filmId);
        if (filmOptional.isPresent()) {
            Film film = filmOptional.get();
            return new FilmDTO<>(film.getId(), film.getTitle(), film.getDescription(), film.getGenre(),
                    film.getTeam(), film.getDurationMinutes(), film.getReleaseDate(), film.getLanguage(),
                    film.getCast(), film.getImageUrl(), film.getTrailerUrl());
        }
        return null; // or throw an exception
    }

}















