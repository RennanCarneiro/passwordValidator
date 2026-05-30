package dio.passwordValidation.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dio.passwordValidation.service.PasswordValidationService;


@RestController
@RequestMapping("/api/auth")
public class PasswordController {
    private final PasswordValidationService service;

    public PasswordController(PasswordValidationService service) {
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