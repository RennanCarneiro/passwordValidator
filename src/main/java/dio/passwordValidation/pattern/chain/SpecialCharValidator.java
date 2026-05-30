package dio.passwordValidation.pattern.chain;

public class SpecialCharValidator extends PasswordValidator{

    @Override
    public void validate(String password) {
        // regex para buscar pelo menos um caractere especial
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"))
            throw new UnsupportedOperationException("A senha deve conter pelo menos um caractere especial.");
        checkNext(password);
    }
    
}
