package lk.ijse.backend.DTO;

import lk.ijse.backend.Entity.FilmHall;
import lk.ijse.backend.Entity.TimeTable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


public class FilmDTO<T> implements Serializable {


    private UUID id;


    private String title;


    private String description;


    private String genre;


    private String team;


    private String durationMinutes;

    private String releaseDate;


    private String language;


    private String cast;







    private  T imageUrl;



    private String trailerUrl;



    // Constructors
    public FilmDTO() {
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

    public T getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(T imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }


    public FilmDTO(UUID id, String title, String description, String genre, String team, String durationMinutes, String releaseDate, String language, String cast, T imageUrl, String trailerUrl) {
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
    }
}


