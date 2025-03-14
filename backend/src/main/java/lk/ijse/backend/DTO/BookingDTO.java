package lk.ijse.backend.DTO;
import jakarta.persistence.*;
import lk.ijse.backend.Entity.Customer;
import lk.ijse.backend.Entity.Payment;
import lk.ijse.backend.Entity.Seats;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bookings")
public class BookingDTO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "booking_date", nullable = false)
    private LocalDateTime bookingDate;

    @Column(name = "booking_reference", unique = true)
    private String bookingReference;

    @Column(name = "booking_status")
    private String status; // RESERVED, CONFIRMED, CANCELLED

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seats seat;

    @OneToOne(mappedBy = "booking", cascade = CascadeType.ALL)
    private Payment payment;


    // Constructors
    public BookingDTO() {
    }

    public BookingDTO(LocalDateTime bookingDate, String bookingReference, String status,
                      Customer customer, Seats seat) {
        this.bookingDate = bookingDate;
        this.bookingReference = bookingReference;
        this.status = status;
        this.customer = customer;
        this.seat = seat;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingReference() {
        return bookingReference;
    }

    public void setBookingReference(String bookingReference) {
        this.bookingReference = bookingReference;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seats getSeat() {
        return seat;
    }

    public void setSeat(Seats seat) {
        this.seat = seat;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingDTO bookingDTO = (BookingDTO) o;
        return Objects.equals(id, bookingDTO.id) &&
                Objects.equals(bookingReference, bookingDTO.bookingReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookingReference);
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", bookingReference='" + bookingReference + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
