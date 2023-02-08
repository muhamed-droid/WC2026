package ba.unsa.etf.rpr.exceptions;

/**
 *Custom Exception made for project
 *
 *
 * @author muhamed-droid
 */

public class MyException extends RuntimeException{
    /**
     *
     * @return instance of TeamDaoSQLImpl
     * @author muhamed-droid
     */
    public MyException(String msg, Exception reason){
        super(msg, reason);
    }


    /**
     *
     * @return instance of TeamDaoSQLImpl
     * @author muhamed-droid
     */
    public MyException(String msg){
        super(msg);
    }
}
