
package lk.ijse.backend.Entity;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "seats")
public class Seats {
    @Id
    private Long id;

    @Column(nullable = false)
    private String rowLetter;

    @Column(name = "seat_number", nullable = false)
    private Integer seatNumber;

    @Column(nullable = false)
    private boolean isAvailable;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "seat_type_id", nullable = false)  // This should be nullable=false
    private SeatType seatType;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "film_hall_id", nullable = false)  // This should be nullable=false
    private FilmHall filmHall;


    // Constructors
    public Seats() {
    }

    public Seats(Long id, String rowLetter, Integer seatNumber, boolean isAvailable, SeatType seatType,FilmHall filmHall) {
        this.id = id;
        this.rowLetter = rowLetter;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.seatType = seatType;
        this.filmHall = filmHall;
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

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Seats)) return false;
        Seats seat = (Seats) o;
        return isAvailable == seat.isAvailable &&
                Objects.equals(id, seat.id) &&
                Objects.equals(rowLetter, seat.rowLetter) &&
                Objects.equals(seatNumber, seat.seatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rowLetter, seatNumber, isAvailable);
    }


    public FilmHall getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(FilmHall filmHall) {
        this.filmHall = filmHall;
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
