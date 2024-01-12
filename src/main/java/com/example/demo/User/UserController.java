package com.example.demo.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController 
{

    @Autowired
    private UserService userService;
 @GetMapping("GetUser")
    public ResponseEntity<UserDTO> getUserById(@RequestParam Long id)
    {
    Optional<UserDTO> userOptional = userService.getUserById(id);

    return userOptional.map(user -> ResponseEntity.ok(user))
        .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping("AddUser")
    public ResponseEntity<Object> createUser(@RequestBody UserDTO userDTO) {
        UserDTO Wallet = userService.createUser(userDTO);
        if (Wallet != null)
        {
            return new ResponseEntity<>(Wallet, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Wallet not configured", HttpStatus.OK);
        }
    }
}