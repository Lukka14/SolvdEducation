package customexceptions.exceptions;

public class DivideByZeroException extends ArithmeticException{
    public DivideByZeroException(String msg){
        super(msg);
    }
}
