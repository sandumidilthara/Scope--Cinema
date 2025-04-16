package lk.ijse.backend.Service;

import lk.ijse.backend.DTO.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getSelectedUser(UUID userId);


    Object getAllUserIds();

    int save(UserDTO user, String role);

    int deleteUserByEmail(String email);

    int saveUser( UserDTO userDTO);

    int saveAdmin(UserDTO userDTO);
}
