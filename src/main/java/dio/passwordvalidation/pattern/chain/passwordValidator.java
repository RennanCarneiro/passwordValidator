package main.java.dio.passwordvalidation.pattern.chain;

public abstract class passwordValidator {
    private passwordValidator nextValidator;

    //metodo para ligar um ao outro
    public passwordValidator linkWith(passwordValidator nexValidator){
        this.nextValidator = nexValidator;
        return nexValidator;
    }

    //cada validador terá esse metodo para implementar
    public abstract void validate(String password);

    //passa o comando para o proximo da fila
    protected void checkNext(String password){
        if (nextValidator != null)
            nextValidator.validate(password);
    }
}
