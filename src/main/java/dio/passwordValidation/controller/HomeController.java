package dio.passwordValidation.controller;

import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Hidden
public class HomeController {

    @GetMapping("/")
    public String redirectSwagger() {
        return "redirect:/swagger-ui/index.html";
    }
}