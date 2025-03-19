package lk.ijse.backend.Entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class FilmRegistration {



    @Id
    private  Long id;
    @ManyToOne
    @JoinColumn(name = "film_hall_id")
    private FilmHall filmHall;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "time_table_id")
    private TimeTable timeTable;

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


    public FilmRegistration(Long id, FilmHall filmHall, Film film, TimeTable timeTable) {
        this.id = id;
        this.filmHall = filmHall;
        this.film = film;
        this.timeTable = timeTable;
    }


    public FilmRegistration() {
    }
}
