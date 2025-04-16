package lk.ijse.backend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


public class UserDTO {

    private UUID userId;
    private String name;
    private String email;
    private String contact;
    private String password;
    private String role; // ADMIN, HOTEL_OWNER, HOTEL_MANAGER

    public UserDTO(UUID userId, String name, String email, String contact, String password, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.password = password;
        this.role = role;
    }

    public UserDTO() {
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
