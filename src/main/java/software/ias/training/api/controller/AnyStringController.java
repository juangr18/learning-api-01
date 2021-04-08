package software.ias.training.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AnyStringController {

    @GetMapping("/sub")
    public String stringHandler() {
        return "Any string";
    }

    @GetMapping("/")
    public String htmlIndex(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"es\">\n" +
                "\n" +
                "<head>\n" +
                "    <title>\n" +
                "        index\n" +
                "    </title>\n" +
                "</head>" +
                "<body>" +
                "<h1>Bienvenido a Spring Boot</h1>" +
                "<h2>Resultado de list:</h2>" +
                "</body>" +
                "</html>";
    }
}
