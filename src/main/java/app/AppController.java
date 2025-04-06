package app;

import app.entity.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api")
public class AppController {

    private final JobService jobService;

    public AppController(JobService jobService) {
        this.jobService = jobService;
    }
    @GetMapping("/greeting")
    public ResponseEntity<String> getGreeting() {
        return ResponseEntity.ok("Hallo, Welt!");
    }

    @PostMapping("/jobs/add")
    public ResponseEntity<Job> createJob(@RequestBody Job job) {

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Eingabe: {0}", job);

        Job savedJob = jobService.saveJob(job);

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "Neuer Job: {0}", savedJob);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedJob);
    }
}
