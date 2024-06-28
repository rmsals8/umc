package umc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") // 기본 주소가 호출되면 index.html 이 호출됨
    public String index(){
        return "index";
    }


}
