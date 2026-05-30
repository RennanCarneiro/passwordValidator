package main.java.dio.passwordvalidation.controller;

import main.java.dio.passwordvalidation.service.passwordValidationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class PasswordController {
    private final passwordValidationService service;

    public passwordController(passwordValidationService service){
        this.service = service;
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validatePassword(@RequestBody String password) {
        try {
            String result = service.processPassword(password);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
