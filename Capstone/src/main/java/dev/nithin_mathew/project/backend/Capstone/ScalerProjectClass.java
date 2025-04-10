package dev.nithin_mathew.project.backend.Capstone;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScalerProjectClass {
    @GetMapping("/hi")
    public String sayHello(){
        return "Hi I'm Nithin Mathew This is My Personal Project";
    }
}
