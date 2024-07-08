package org.example.flowing.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    private ResponseEntity<UserDTO> registerUser (@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(this.userService.saveUser(userDTO));
    }
    @GetMapping("/{userId}")
    private ResponseEntity<UserDTO> getUser (@PathVariable Long userId) {
        return ResponseEntity.ok(this.userService.getUser(userId));
    }
}
