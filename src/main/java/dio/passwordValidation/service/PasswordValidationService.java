package dio.passwordValidation.service;
import dio.passwordValidation.pattern.chain.*; // Importa todos os validadores da Chain
import org.springframework.stereotype.Service; // Importa a anotação do Spring

@Service
public class PasswordValidationService {

    private final PasswordValidator validatorChain;

    public PasswordValidationService() {
        // Tamanho -> Maiúscula -> Especial
        this.validatorChain = new LengthValidator();
        this.validatorChain.linkWith(new UpperCaseValidator()).linkWith(new SpecialCharValidator()); 
    }

    public String processPassword(String password){
        //validação falha -> exceção lançada e corta o fluxo
        validatorChain.validate(password);
        String mensagem = "Senha validada com sucesso. Nível de segurança adequado.";
        return mensagem;
    }
}
