package customexceptions.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidYearException extends IllegalArgumentException {
    private static final Logger LOGGER = LogManager.getLogger(InvalidYearException.class);
    public InvalidYearException(String msg){
        super(msg);
        LOGGER.warn("Exception generated. message:\n"+msg);
    }
}
