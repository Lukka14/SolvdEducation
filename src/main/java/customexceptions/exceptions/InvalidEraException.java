package customexceptions.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidEraException extends IllegalArgumentException {
    private static final Logger LOGGER = LogManager.getLogger(InvalidEraException.class);
    public InvalidEraException(String msg){
        super(msg);
        LOGGER.warn("Exception generated. message:\n"+msg);
    }
}
