package net.engineeringdigest.journalApp.controllers;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/public")
@RestController
public class PublicController {

    @Autowired
    private UserService userService;

    @GetMapping("health-check")
    public String healthCheck() {
        return "OK";
    }

    @PostMapping("/create-user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        boolean flag = userService.saveNewUser(user);
        if (flag) {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
