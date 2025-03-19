//package lk.ijse.backend.Entity;
//
//
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
//@Entity
//@Table(name = "seat_type")
//public class SeatType {
//
//    @Id
//
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String type;
//
//    @Column
//    private String description;
//
//    @Column
//    private Integer quantity;
//
//    @Column
//    private Double price;
//
//
//
//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seatType", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Seats>  seats;
//
//    // Constructors
//    public SeatType() {
//    }
//
//    public SeatType(Long id,String type, String description, Integer quantity, Double price) {
//        this.id = id;
//        this.type = type;
//        this.description = description;
//        this.quantity = quantity;
//        this.price = price;
//       // this.seats = new ArrayList<>();
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
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
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
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof SeatType)) return false;
//        SeatType seatType = (SeatType) o;
//        return Objects.equals(id, seatType.id) &&
//                Objects.equals(type, seatType.type);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, type);
//    }
//
//    @Override
//    public String toString() {
//        return "SeatType{" +
//                "id=" + id +
//                ", type='" + type + '\'' +
//                ", description='" + description + '\'' +
//                ", quantity=" + quantity +
//                ", price=" + price +
//                '}';
//    }
//}








package lk.ijse.backend.Entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seat_type")
public class SeatType {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String type;

    @Column
    private String description;

    @Column
    private Integer quantity;

    @Column
    private Double price;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "seatType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Seats> seats;

    // Constructors
    public SeatType() {
    }

    public SeatType(Long id, String type, String description, Integer quantity, Double price  ) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.quantity = quantity;
        this.price = price;

    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Seats> getSeats() {
        return seats;
    }

    public void setSeats(List<Seats> seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeatType)) return false;
        SeatType seatType = (SeatType) o;
        return Objects.equals(id, seatType.id) &&
                Objects.equals(type, seatType.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    @Override
    public String toString() {
        return "SeatType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
