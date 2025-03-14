package lk.ijse.backend.Service;

import jakarta.transaction.Transactional;
import lk.ijse.backend.DTO.ExampleDTO;
import lk.ijse.backend.Entity.Example;
import lk.ijse.backend.repo.ExampleRepo;
import lk.ijse.backend.util.ImageUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lk.ijse.backend.enums.ImageType;
import java.util.List;
@Service
public class ExampleServiceImpl  implements ExampleService{
    private static final Logger logger = LoggerFactory.getLogger(ExampleServiceImpl.class);
    @Autowired
    private ExampleRepo exampleRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ImageUtil imageUtil;

    @Override
    @Transactional
    public ExampleDTO<String> save(ExampleDTO spiceDTO, MultipartFile file) {
        String base64Image = imageUtil.saveImage( ImageType.EXAMPLE,file);
        logger.info("Base64 image: {}", base64Image);
        Example spice = modelMapper.map(spiceDTO, Example.class);
        spice.setImageURL(base64Image);
        try {
            Example savedSpice = exampleRepo.save(spice);
            ExampleDTO<String> stringSpiceDTO = modelMapper.map(savedSpice, ExampleDTO.class);
            stringSpiceDTO.setImageURL(base64Image);
            return stringSpiceDTO;
        } catch (Exception e) {
            logger.error("Failed to save spice: {}", spice, e);
            throw new RuntimeException("Failed to save spice");
        }
    }

    @Override
    public List<ExampleDTO<String>> getAll() {
        List<Example> spices = exampleRepo.findAll();
        List<ExampleDTO<String>> spiceDTOS = modelMapper.map(spices, new TypeToken<List<ExampleDTO<String>>>() {}.getType());
        for (ExampleDTO<String> spiceDTO : spiceDTOS) {
            spices.stream().filter(spice ->
                            spice.getId().equals(spiceDTO.getId()))
                    .findFirst()
                    .ifPresent(spice -> spiceDTO.setImageURL(imageUtil.getImage(spice.getImageURL())));
        }
        return spiceDTOS;
    }





}
