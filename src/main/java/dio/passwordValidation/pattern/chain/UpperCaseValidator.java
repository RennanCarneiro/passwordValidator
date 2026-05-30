package dio.passwordValidation.pattern.chain;

public class UpperCaseValidator  extends PasswordValidator{

    @Override
    public void validate(String password) {
        if(!password.matches(".*[A-Z].*"))
            throw new UnsupportedOperationException("A senha deve conter pelo menos uma letra maiuscula.");
        checkNext(password);
    }
}