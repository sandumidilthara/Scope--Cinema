package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.ExampleDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ExampleService {

    ExampleDTO<String> save(ExampleDTO spiceDTO, MultipartFile file);
    List<ExampleDTO<String>> getAll();
}
