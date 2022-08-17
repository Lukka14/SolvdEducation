package customexceptions.exceptions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidMonthException extends IllegalArgumentException {
    private static final Logger logger = LogManager.getLogger(InvalidMonthException.class);
    public InvalidMonthException(String msg){
        super(msg);
        logger.warn("Exception generated. message:\n"+msg);
    }
}
