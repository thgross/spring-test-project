package app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @Value("${app.schedule.rate}")
    private long rate;

    @Scheduled(fixedRateString = "${app.schedule.rate}")
    public void reportCurrentTime() {
        logger.log(Level.INFO, "The time is now {0} [Schedlule rate is {1}]", new Object[]{dateFormat.format(new Date()), rate});
    }
}
