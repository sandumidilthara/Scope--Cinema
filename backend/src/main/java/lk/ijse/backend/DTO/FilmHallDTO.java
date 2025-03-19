package lk.ijse.backend.DTO;

import jakarta.persistence.Column;

import java.io.Serializable;
import java.util.UUID;

public class FilmHallDTO<T> implements Serializable {



    UUID id;
    private T imageURL;
    String name;


    private String contactNumber;


    private String location;


    private String description;


   private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public T getImageURL() {
        return imageURL;
    }

    public void setImageURL(T imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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


    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public FilmHallDTO() {
    }


    public FilmHallDTO(UUID id, T imageURL, String name, String contactNumber, String location, String description, String email) {
        this.id = id;
        this.imageURL = imageURL;
        this.name = name;
        this.contactNumber = contactNumber;
        this.location = location;
        this.description = description;
        this.email = email;
    }
}
