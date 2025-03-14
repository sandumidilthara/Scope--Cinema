package lk.ijse.backend.DTO;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;



public class PaymentDTO {



    private Long id;


    private Double amount;

    private LocalDateTime paymentDate;


    private String paymentMethod; // CREDIT_CARD, DEBIT_CARD, PAYPAL, etc.


    private String transactionId;


    private String status; // PENDING, COMPLETED, FAILED, REFUNDED


    private BookingDTO bookingDTO;

    // Constructors
    public PaymentDTO() {
    }

    public PaymentDTO(Double amount, LocalDateTime paymentDate, String paymentMethod,
                      String transactionId, String status, BookingDTO bookingDTO) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.transactionId = transactionId;
        this.status = status;
        this.bookingDTO = bookingDTO;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BookingDTO getBooking() {
        return bookingDTO;
    }

    public void setBooking(BookingDTO bookingDTO) {
        this.bookingDTO = bookingDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentDTO paymentDTO = (PaymentDTO) o;
        return Objects.equals(id, paymentDTO.id) &&
                Objects.equals(transactionId, paymentDTO.transactionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", paymentDate=" + paymentDate +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
