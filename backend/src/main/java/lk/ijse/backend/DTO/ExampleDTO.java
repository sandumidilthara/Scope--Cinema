package lk.ijse.backend.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.UUID;
@NoArgsConstructor
@Controller
@Getter
@Setter



public class ExampleDTO<T> implements Serializable {



    UUID id;
    private T imageURL;
    String name;


    public T getImageURL() {
        return imageURL;
    }

    public void setImageURL(T imageURL) {
        this.imageURL = imageURL;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
