package lk.ijse.backend.DTO;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;


public class FilmHallDTO {


    private Long id;

    private String name;


    private Integer totalCapacity;


    private String location;


    private String description;


    private String hallType; // Regular, IMAX, VIP, etc.



    private MultipartFile image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Integer totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    public  MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public FilmHallDTO(Long id, String name,  Integer totalCapacity, String location, String description, String hallType,  MultipartFile image) {
        this.id = id;
        this.name = name;
        this.totalCapacity = totalCapacity;
        this.location = location;
        this.description = description;
        this.hallType = hallType;
        this.image = image;
    }

    public FilmHallDTO() {
    }

    @Override
    public String toString() {
        return "FilmHallDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalCapacity=" + totalCapacity +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", hallType='" + hallType + '\'' +
                ", image=" + image +
                '}';
    }
}
