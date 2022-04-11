package se.parkster.rps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class HttpApi {
    private static final Logger log = LoggerFactory.getLogger(HttpApi.class);

    private final Database database;

    public HttpApi(Database database) {
        this.database = database;
    }

    @GetMapping
    public String index(ModelMap modelMap) {
        log.info("Loading index.html");
        List<String> greetings = database.findAll().stream().map(Greeting::text).toList();
        modelMap.addAttribute("greetings", greetings);
        return "index";
    }

    @PostMapping("/greetings")
    public String greet(@RequestParam("greeting") String greeting) {
        log.info("Greeting {}", greeting);
        database.save(new Greeting(UUID.randomUUID(), greeting));
        return "redirect:/";
    }
}
