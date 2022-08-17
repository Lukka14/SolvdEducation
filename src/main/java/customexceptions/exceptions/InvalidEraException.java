package customexceptions.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidEraException extends IllegalArgumentException {
    private static final Logger logger = LogManager.getLogger(InvalidEraException.class);
    public InvalidEraException(String msg){
        super(msg);
        logger.warn("Exception generated. message:\n"+msg);
    }
}
