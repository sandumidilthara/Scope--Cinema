package lk.ijse.backend.DTO;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lk.ijse.backend.Entity.Film;
import lk.ijse.backend.Entity.FilmHall;
import lk.ijse.backend.Entity.TimeTable;

import java.util.UUID;

public class FilmRegistrationDTO {



    private  Long id;

    private FilmHall filmHall;


    private Film film;


    private TimeTable timeTable;

    public FilmRegistrationDTO(Long id, FilmHall filmHall, Film film, TimeTable timeTable) {
        this.id = id;
        this.filmHall = filmHall;
        this.film = film;
        this.timeTable = timeTable;
    }


    public FilmRegistrationDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FilmHall getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(FilmHall filmHall) {
        this.filmHall = filmHall;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public TimeTable getTimeTable() {
        return timeTable;
    }

    public void setTimeTable(TimeTable timeTable) {
        this.timeTable = timeTable;
    }
}
