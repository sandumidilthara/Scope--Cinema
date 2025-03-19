package lk.ijse.backend.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
   UUID id;

    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String description;

    @Column
    private String genre;

    @Column
    private String team;

   // @Column(name = "duration_minutes")
    private String durationMinutes;

    @Column(name = "release_date")
    private String releaseDate;

    @Column
    private String language;

    @Column
    private String cast;




    @Column( name = "film_photo")
    private String imageUrl;

    @Column( name = "trailer")
    private String trailerUrl;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "film", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FilmRegistration> filmRegistrationLists;

    // Constructors
    public Film() {
    }

    public Film(UUID id, String title, String description, String genre, String team, String durationMinutes, String releaseDate, String language, String cast, String imageUrl, String trailerUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.team = team;
        this.durationMinutes = durationMinutes;
        this.releaseDate = releaseDate;
        this.language = language;
        this.cast = cast;
        this.imageUrl = imageUrl;
        this.trailerUrl = trailerUrl;
        this.filmRegistrationLists = new ArrayList<>();
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(String durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
       this.cast = cast;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public List<FilmRegistration> getFilmRegistrationLists() {
        return filmRegistrationLists;
    }

    public void setFilmRegistrationLists(List<FilmRegistration> filmRegistrationLists) {
        this.filmRegistrationLists = filmRegistrationLists;
    }
}


