package ba.unsa.etf.rpr.exceptions;

public class MyException extends RuntimeException{
    public MyException(String msg, Exception reason){
        super(msg, reason);
    }

    public MyException(String msg){
        super(msg);
    }
}
