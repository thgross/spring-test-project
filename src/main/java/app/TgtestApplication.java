package app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
@EnableScheduling
public class TgtestApplication {

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(TgtestApplication.class, args);
    }

    // Generics
    public <T> T pick(T a1, T a2) {
        return a1;
    }

    @GetMapping("/")
    public String index() {
        var sb = new StringBuilder();

        Logger.getLogger(Logger.GLOBAL_LOGGER_NAME).log(Level.INFO, "GET /");

        sb.append("Hello World!");
        sb.append("<br>");
        sb.append(environment.getProperty("Path"));

//        IntegrationFlow
//                .from(Files.inboundAdapter(tmpDir.getRoot(), e -> e.poller(Pollers.fixedRate(10))).get()
//                        .channel()
//        ;

        // Type Interference - siehe https://docs.oracle.com/javase/tutorial/java/generics/genTypeInference.html
        var pick_return = pick(
                new ArrayList<Integer>() {{
                    add(1);
                    add(2);
                    add(3);
                }},
                new ArrayList<String>() {{
                    add("s1");
                    add("s2");
                    add("s3");
                }}
        );

        class InlineClass {
            public String toString() {
                return "string! aus einer inline-Klasse";
            }
        }

        sb.append("<br>");
        sb.append(pick_return);
        sb.append("<br>");
        sb.append(pick_return.getClass());

        sb.append("<br>");
        sb.append(new InlineClass());

        return sb.toString();
    }
}
