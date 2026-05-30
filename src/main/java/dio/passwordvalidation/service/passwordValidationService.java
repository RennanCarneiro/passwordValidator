package main.java.dio.passwordvalidation.service;

import main.java.dio.passwordvalidation.pattern.chain.*;

public class passwordValidationService {

    private final passwordValidator validatorChain;

    public passwordValidationService() {
        // Tamanho -> Maiúscula -> Especial
        this.validatorChain = new lengthValidator();
        this.validatorChain.linkWith(new upperCaseValidator()).linkWith(new specialCharValidator()); 
    }

    public String processPassword(String password){
        //validação falha -> exceção lançada e corta o fluxo
        validatorChain.validate(password);
        String mensagem = "Senha validada com sucesso. Nível de segurança adequado.";
        return mensagem;
    }
}
