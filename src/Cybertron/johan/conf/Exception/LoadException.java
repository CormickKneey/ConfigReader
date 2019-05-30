package Cybertron.johan.conf.Exception;

/**
 * @author Johan
 */

public class LoadException extends RuntimeException {

    private static final long serialVersionUID = 3L;

    public LoadException(String msg){
        super(msg);
    }

    public LoadException(Throwable t){
        super(t);
    }

}