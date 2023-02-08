package ba.unsa.etf.rpr.exceptions;

/**
 *Custom Exception made for project
 *
 *
 * @author muhamed-droid
 */

public class MyException extends RuntimeException{
    public MyException(String msg, Exception reason){
        super(msg, reason);
    }

    public MyException(String msg){
        super(msg);
    }
}
