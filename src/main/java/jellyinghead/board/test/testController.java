package jellyinghead.board.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class testController {

    @GetMapping("/simple")
    public String test() {
        return "simple";
    }

}
