package customexceptions.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidDayException extends IllegalArgumentException {
    private static final Logger LOGGER = LogManager.getLogger(InvalidDayException.class);
    public InvalidDayException(String msg){
        super(msg);
        LOGGER.warn("Exception generated. message:\n"+msg);
    }
}
