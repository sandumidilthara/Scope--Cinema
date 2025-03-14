package lk.ijse.backend.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "time_tables")
public class TimeTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "show_time", nullable = false)
    private LocalDateTime showTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column
    private Double price;

    @Column(name = "is_available")
    private boolean isAvailable = true;

    @ManyToOne
    @JoinColumn(name = "film_id", nullable = false)
    private Film film;

    @ManyToOne
    @JoinColumn(name = "film_hall_id", nullable = false)
    private FilmHall filmHall;

    // Constructors
    public TimeTable() {
    }

    public TimeTable(LocalDateTime showTime, LocalDateTime endTime, Double price,
                     boolean isAvailable, Film film, FilmHall filmHall) {
        this.showTime = showTime;
        this.endTime = endTime;
        this.price = price;
        this.isAvailable = isAvailable;
        this.film = film;
        this.filmHall = filmHall;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public FilmHall getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(FilmHall filmHall) {
        this.filmHall = filmHall;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeTable timeTable = (TimeTable) o;
        return Objects.equals(id, timeTable.id) &&
                Objects.equals(showTime, timeTable.showTime) &&
                Objects.equals(film, timeTable.film) &&
                Objects.equals(filmHall, timeTable.filmHall);
    }
}
