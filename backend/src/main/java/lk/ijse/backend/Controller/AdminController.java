package lk.ijse.backend.Controller;

import  lk.ijse.backend.DTO.AuthDTO;
import  lk.ijse.backend.DTO.UserDTO;
import  lk.ijse.backend.Service.UserService;
import  lk.ijse.backend.util.JwtUtil;
import lk.ijse.backend.util.ResponseUtil;
import  lk.ijse.backend.util.VarList;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
@CrossOrigin(origins = "http://localhost:63342")
public class AdminController {
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public AdminController(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @GetMapping("/adminCheck")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminCheck(){
      return  "Admin access passed!";    }

    @GetMapping("/userCheck")
    @PreAuthorize("hasRole('USER')")
    public String userCheck(){
        return "User access passed!";
    }

    @GetMapping("/managerCheck")
    @PreAuthorize("hasRole('MANAGER')")
    public String managerCheck(){
        return "Manager access passed!";
    }
    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseUtil> getAllUsers() {
        try {
            System.out.println("Fetching all users for admin...");
            List<UserDTO> users = userService.getAllUsers();
            System.out.println("Users retrieved: " + users.size());
            return ResponseEntity.ok(new ResponseUtil(VarList.OK, "Users retrieved successfully", users));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(VarList.Internal_Server_Error, "Error retrieving users: " + e.getMessage(), null));
        }
    }

    @PostMapping(value = "/register")
//    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ResponseUtil> registerAdmin(@RequestBody @Valid UserDTO userDTO) {
        try {
            int res = userService.saveAdmin(userDTO);
            switch (res) {
                case VarList.Created -> {
                    String token = jwtUtil.generateToken(userDTO);
                    AuthDTO authDTO = new AuthDTO();
                    authDTO.setEmail(userDTO.getEmail());
                    authDTO.setToken(token);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseUtil(VarList.Created, "Success", authDTO));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseUtil(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseUtil(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseUtil(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

}
