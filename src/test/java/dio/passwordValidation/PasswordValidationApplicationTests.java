package dio.passwordValidation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import dio.passwordValidation.service.PasswordValidationService;

@SpringBootTest
class PasswordValidationApplicationTests {

	private PasswordValidationService service;

    // garantindo que tem um serviço novo e limpo para testar.
    @BeforeEach
    void setUp() {
        this.service = new PasswordValidationService();
    }

    @Test
    void deveValidarSenhaForteComSucesso() {
        String resultado = service.processPassword("SenhaForte@2026");
        assertEquals("Senha validada com sucesso. Nível de segurança adequado.", resultado);
    }

    @Test
    void deveLancarExcecaoQuandoSenhaForCurta() {
        // LengthValidator corta o fluxo?
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.processPassword("Curta@1");
        });
        
        // Verificarse a mensagem do erro é exatamente a que espera
        assertTrue(exception.getMessage().contains("pelo menos 8 caracteres"));
    }

    @Test
    void deveLancarExcecaoQuandoNaoTiverMaiuscula() {
        // Testar se o UpperCaseValidator corta o fluxo
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.processPassword("senhasem@2026");
        });
        
        assertTrue(exception.getMessage().contains("letra maiuscula"));
    }

    @Test
    void deveLancarExcecaoQuandoNaoTiverCaractereEspecial() {
        // Testar se o SpecialCharValidator corta o fluxo
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.processPassword("SenhaSemEspecial2026");
        });
        
        assertTrue(exception.getMessage().contains("caractere especial"));
    }
}
