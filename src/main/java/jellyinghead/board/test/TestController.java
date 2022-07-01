package jellyinghead.board.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/simple")
    public String test() {
        return "simple";
    }

    @GetMapping("/test/read")
    public ModelAndView testRead() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("jpa_test");
        mav.addObject("testModel", testService.getTestModel(1));
        return mav;
    }

    @PostMapping("/test/create")
    public ModelAndView testCreate() {
        testService.addTestModel();
        return new ModelAndView();
    }

    @PutMapping("/test/update")
    public ModelAndView testUpdate() {
        testService.updateTestModel();
        return new ModelAndView();
    }

    @DeleteMapping("/test/delete")
    public ModelAndView testDelete() {
        testService.deleteTestModel();
        return new ModelAndView();
    }

}
