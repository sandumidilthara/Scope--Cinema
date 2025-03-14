package lk.ijse.backend.DTO;


import jakarta.persistence.*;

import java.util.Objects;

public class SeatTypeDTO {


    private Long id;


    private String type;


    private String description;


    private Integer quantity;


    private Double price;

    // Constructors
    public SeatTypeDTO() {
    }

    public SeatTypeDTO(String type, String description, Integer quantity, Double price) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SeatTypeDTO)) return false;
        SeatTypeDTO seatTypeDTO = (SeatTypeDTO) o;
        return Objects.equals(id, seatTypeDTO.id) &&
                Objects.equals(type, seatTypeDTO.type);
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
