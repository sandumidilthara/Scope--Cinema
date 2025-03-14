package lk.ijse.backend.DTO;

import jakarta.persistence.*;
import lk.ijse.backend.Entity.FilmHall;
import lk.ijse.backend.Entity.TimeTable;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public class FilmDTO {


    private Long id;


    private String title;


    private String description;


    private String genre;


    private String director;


    private Integer durationMinutes;

    private LocalDate releaseDate;


    private String language;


    private String posterUrl;


    private boolean isActive = true;


    private List<TimeTable> timeTables;


    private List<UserDTO> users;


    private FilmHall filmHall;



    private String imageUrl;



    private String trailerUrl;



    // Constructors
    public FilmDTO() {
    }

    public FilmDTO(Long id, String title, String description, String genre, String director, Integer durationMinutes, LocalDate releaseDate, String language, String posterUrl, boolean isActive, List<TimeTable> timeTables, List<UserDTO> users, FilmHall filmHall, String imageUrl, String trailerUrl) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.director = director;
        this.durationMinutes = durationMinutes;
        this.releaseDate = releaseDate;
        this.language = language;
        this.posterUrl = posterUrl;
        this.isActive = isActive;
        this.timeTables = timeTables;
        this.users = users;
        this.filmHall = filmHall;
        this.imageUrl = imageUrl;
        this.trailerUrl = trailerUrl;
    }


    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<TimeTable> getTimeTables() {
        return timeTables;
    }

    public void setTimeTables(List<TimeTable> timeTables) {
        this.timeTables = timeTables;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public FilmHall getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(FilmHall filmHall) {
        this.filmHall = filmHall;
    }



    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", durationMinutes=" + durationMinutes +
                '}';
    }
}


