package lk.ijse.backend.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.time.LocalDate;
import java.time.LocalDateTime;


public class BookingDTO {


    private Long id;


    private LocalDate bookingDate;


    private String film;



    private String filmHall;




    private String time;



    private String seat;
    private String email;

    public BookingDTO(Long id, LocalDate bookingDate, String film, String filmHall, String time, String seat,String email) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.film = film;
        this.filmHall = filmHall;
        this.time = time;
        this.seat = seat;
        this.email = email;
    }

    public BookingDTO() {
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
