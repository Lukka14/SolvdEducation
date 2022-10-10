package customexceptions.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidMonthException extends IllegalArgumentException {
    private static final Logger LOGGER = LogManager.getLogger(InvalidMonthException.class);
    public InvalidMonthException(String msg){
        super(msg);
        LOGGER.warn("Exception generated. message:\n"+msg);
    }
}
