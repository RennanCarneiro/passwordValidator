package dio.passwordValidation.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import dio.passwordValidation.service.PasswordValidationService;


@RestController
@RequestMapping("/api/auth")
@Tag(name = "Validação de Senhas", description = "Endpoint para verificar a força e segurança de senhas")
public class PasswordController {

    private final PasswordValidationService service;

    public PasswordController(PasswordValidationService service) {
        this.service = service;
    }

    @Operation(summary = "Valida uma senha", description = "Passa a senha por uma esteira de validações: mínimo de 8 caracteres, pelo menos uma letra maiúscula e pelo menos um caractere especial.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Senha forte e válida"),
            @ApiResponse(responseCode = "400", description = "Senha fraca (falhou em alguma regra de negocio)")
    })
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