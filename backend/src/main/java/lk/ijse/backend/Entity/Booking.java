package lk.ijse.backend.Entity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bookings")
public class Booking {


    @Id

    private Long id;

    @Column(name = "booking_date", nullable = false)
    private LocalDate bookingDate;

    @Column(name = "film_name")
    private String film;


    @Column(name = "location")
    private String filmHall;


    @Version
    private Long version;



    @Column(name = "time")
    private String time;


    @Column(name = "seatNumber")
    private String seat;


    @Column(name = "Customeremail")
    private String email;

    public Booking( Long id ,LocalDate bookingDate, String film, String filmHall, String time, String seat,String email) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.film = film;
        this.filmHall = filmHall;
        this.time = time;
        this.seat = seat;
        this.email = email;
    }



    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(String filmHall) {
        this.filmHall = filmHall;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
