package customexceptions.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidDayException extends IllegalArgumentException {
    private static final Logger logger = LogManager.getLogger(InvalidDayException.class);
    public InvalidDayException(String msg){
        super(msg);
        logger.warn("Exception generated. message:\n"+msg);
    }
}
