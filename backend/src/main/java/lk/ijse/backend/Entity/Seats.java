//package lk.ijse.backend.Entity;
//import jakarta.persistence.*;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "seats")
//public class Seats {
//
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String rowLetter;
//
//
//    @Column(name = "seat_number", nullable = false)
//    private Integer seatNumber;
//
//    @Column(name = "seat_type")
//    private String seatType; // Regular, VIP, Couple, etc.
//
//    @Column
//    private Double price;
//
//    @ManyToOne
//    @JoinColumn(name = "film_hall_id", nullable = false)
//    private FilmHall filmHall;
//
//    @OneToMany(mappedBy = "seat")
//    private List<Booking> bookings;
//
//
//    // Constructors
//    public Seats() {
//    }
//
//    public Seats(String rowLetter, Integer seatNumber, String seatType, Double price, FilmHall filmHall) {
//        this.rowLetter = rowLetter;
//        this.seatNumber = seatNumber;
//        this.seatType = seatType;
//        this.price = price;
//        this.filmHall = filmHall;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRowLetter() {
//        return rowLetter;
//    }
//
//    public void setRowLetter(String rowLetter) {
//        this.rowLetter = rowLetter;
//    }
//
//    public Integer getSeatNumber() {
//        return seatNumber;
//    }
//
//    public void setSeatNumber(Integer seatNumber) {
//        this.seatNumber = seatNumber;
//    }
//
//    public String getSeatType() {
//        return seatType;
//    }
//
//    public void setSeatType(String seatType) {
//        this.seatType = seatType;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//
//    public FilmHall getFilmHall() {
//        return filmHall;
//    }
//
//    public void setFilmHall(FilmHall filmHall) {
//        this.filmHall = filmHall;
//    }
//
//    public List<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }
//
//
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Seats seat = (Seats) o;
//        return Objects.equals(id, seat.id) &&
//                Objects.equals(filmHall, seat.filmHall) &&
//                Objects.equals(rowLetter, seat.rowLetter) &&
//                Objects.equals(seatNumber, seat.seatNumber);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, filmHall, rowLetter, seatNumber);
//    }
//
//    @Override
//    public String toString() {
//        return "Seat{" +
//                "id=" + id +
//                ", rowLetter='" + rowLetter + '\'' +
//                ", seatNumber=" + seatNumber +
//                ", seatType='" + seatType + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}



//package lk.ijse.backend.Entity;
//
//import jakarta.persistence.*;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "seats")
//public class Seats {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private String rowLetter;
//
//    @Column(name = "seat_number", nullable = false)
//    private Integer seatNumber;
//
//    @ManyToOne
//    @JoinColumn(name = "film_hall_id", nullable = false)
//    private FilmHall filmHall;
//
//    @ManyToOne
//    @JoinColumn(name = "seat_type_id", nullable = false)
//    private SeatType seatType;
//
//    @OneToMany(mappedBy = "seat")
//    private List<Booking> bookings;
//
//    // Constructors
//    public Seats() {
//    }
//
//    public Seats(String rowLetter, Integer seatNumber, FilmHall filmHall, SeatType seatType) {
//        this.rowLetter = rowLetter;
//        this.seatNumber = seatNumber;
//        this.filmHall = filmHall;
//        this.seatType = seatType;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getRowLetter() {
//        return rowLetter;
//    }
//
//    public void setRowLetter(String rowLetter) {
//        this.rowLetter = rowLetter;
//    }
//
//    public Integer getSeatNumber() {
//        return seatNumber;
//    }
//
//    public void setSeatNumber(Integer seatNumber) {
//        this.seatNumber = seatNumber;
//    }
//
//    public FilmHall getFilmHall() {
//        return filmHall;
//    }
//
//    public void setFilmHall(FilmHall filmHall) {
//        this.filmHall = filmHall;
//    }
//
//    public SeatType getSeatType() {
//        return seatType;
//    }
//
//    public void setSeatType(SeatType seatType) {
//        this.seatType = seatType;
//    }
//
//    public List<Booking> getBookings() {
//        return bookings;
//    }
//
//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Seats)) return false;
//        Seats seat = (Seats) o;
//        return Objects.equals(id, seat.id) &&
//                Objects.equals(filmHall, seat.filmHall) &&
//                Objects.equals(rowLetter, seat.rowLetter) &&
//                Objects.equals(seatNumber, seat.seatNumber) &&
//                Objects.equals(seatType, seat.seatType);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, filmHall, rowLetter, seatNumber, seatType);
//    }
//
//    @Override
//    public String toString() {
//        return "Seat{" +
//                "id=" + id +
//                ", rowLetter='" + rowLetter + '\'' +
//                ", seatNumber=" + seatNumber +
//                ", seatType=" + seatType +
//                '}';
//    }
//}




package lk.ijse.backend.Entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seats")
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rowLetter;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Column(nullable = false)
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "film_hall_id", nullable = false)
    private FilmHall filmHall;

    @ManyToOne
    @JoinColumn(name = "seat_type_id", nullable = false)
    private SeatType seatType;

    @OneToMany(mappedBy = "seat")
    private List<Booking> bookings;

    // Constructors
    public Seats() {
    }

    public Seats(String rowLetter, Integer seatNumber, boolean isAvailable, FilmHall filmHall, SeatType seatType) {
        this.rowLetter = rowLetter;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.filmHall = filmHall;
        this.seatType = seatType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRowLetter() {
        return rowLetter;
    }

    public void setRowLetter(String rowLetter) {
        this.rowLetter = rowLetter;
    }

    public Integer getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public FilmHall getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(FilmHall filmHall) {
        this.filmHall = filmHall;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seats)) return false;
        Seats seat = (Seats) o;
        return Objects.equals(id, seat.id) &&
                Objects.equals(filmHall, seat.filmHall) &&
                Objects.equals(rowLetter, seat.rowLetter) &&
                Objects.equals(seatNumber, seat.seatNumber) &&
                Objects.equals(seatType, seat.seatType) &&
                isAvailable == seat.isAvailable;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, filmHall, rowLetter, seatNumber, seatType, isAvailable);
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", rowLetter='" + rowLetter + '\'' +
                ", seatNumber=" + seatNumber +
                ", isAvailable=" + isAvailable +
                ", seatType=" + seatType +
                '}';
    }
}
