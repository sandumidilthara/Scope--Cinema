package lk.ijse.backend.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "film_hall")
public class FilmHall {
@Id
@GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    private String imageURL;

    @Column(nullable = false)
    private String name;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column
    private String location;

    @Column
    private String description;

    @Column(name = "email")
    private String email;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "filmHall", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmRegistration> filmRegistrationList;

    public FilmHall(UUID id, String imageURL, String name, String contactNumber, String location, String description, String email ) {
        this.id = id;
        this.imageURL = imageURL;
        this.name = name;
        this.contactNumber = contactNumber;
        this.location = location;
        this.description = description;
        this.email = email;

    }

    public FilmHall() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<FilmRegistration> getFilmRegistrationList() {
        return filmRegistrationList;
    }

    public void setFilmRegistrationList(List<FilmRegistration> filmRegistrationList) {
        this.filmRegistrationList = filmRegistrationList;
    }
}
