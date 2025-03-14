package lk.ijse.backend.Entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bookings")
public class Booking {


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
    public Booking() {
    }

    public Booking(LocalDateTime bookingDate, String bookingReference, String status,
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
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) &&
                Objects.equals(bookingReference, booking.bookingReference);
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
