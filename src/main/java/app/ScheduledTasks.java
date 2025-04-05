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

    @Value("${app.schedule.delay}")
    private long delay;

//    @Scheduled(fixedRateString = "${app.schedule.rate}")
    @Scheduled(fixedDelayString = "${app.schedule.delay}")
    public void reportCurrentTime() throws InterruptedException {
        logger.log(Level.INFO, "The time is now {0} (Schedule delay is {1}, Sleep is {2})", new Object[]{dateFormat.format(new Date()), delay, 7000});
        Thread.sleep(7000); // dauert 7 Sekunden
    }
}
