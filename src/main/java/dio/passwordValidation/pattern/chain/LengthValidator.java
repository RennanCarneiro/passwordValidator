package dio.passwordValidation.pattern.chain;

public class LengthValidator extends PasswordValidator {
    @Override
    public void validate(String password){
        if(password == null || password.length() < 0)
            throw new IllegalArgumentException("A senha deve conter pelo menos 8 caracteres.");
        checkNext(password);
    }
}
