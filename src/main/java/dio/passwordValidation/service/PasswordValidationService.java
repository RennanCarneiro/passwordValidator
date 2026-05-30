package main.java.dio.passwordvalidation.service;

import main.java.dio.passwordvalidation.pattern.chain.*;

public class passwordValidationService {

    private final PasswordValidator validatorChain;

    public passwordValidationService() {
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
