package customexceptions.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidYearException extends IllegalArgumentException {
    private static final Logger logger = LogManager.getLogger(InvalidYearException.class);
    public InvalidYearException(String msg){
        super(msg);
        logger.warn("Exception generated. message:\n"+msg);
    }
}
