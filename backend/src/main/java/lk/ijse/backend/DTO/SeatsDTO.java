
package lk.ijse.backend.DTO;

import lk.ijse.backend.Entity.FilmHall;

import java.util.Objects;

public class SeatsDTO {
    private Long id;
    private String rowLetter;
    private Integer seatNumber;
    private boolean isAvailable;
    private SeatTypeDTO seatType;  // Changed from SeatType entity to SeatTypeDTO
    private FilmHall filmHall;
    // Constructors
    public SeatsDTO() {
    }

    public SeatsDTO(Long id, String rowLetter, Integer seatNumber, boolean isAvailable, SeatTypeDTO seatType,FilmHall filmHall) {
        this.id = id;
        this.rowLetter = rowLetter;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
        this.seatType = seatType;
        this.filmHall =  filmHall;

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

    public SeatTypeDTO getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatTypeDTO seatType) {
        this.seatType = seatType;
    }

    public FilmHall getFilmHall() {
        return filmHall;
    }

    public void setFilmHall(FilmHall filmHall) {
        this.filmHall = filmHall;
    }


    @Override
    public String toString() {
        return "SeatDTO{" +
                "id=" + id +
                ", rowLetter='" + rowLetter + '\'' +
                ", seatNumber=" + seatNumber +
                ", isAvailable=" + isAvailable +
                ", seatType=" + seatType +
                '}';
    }
}
