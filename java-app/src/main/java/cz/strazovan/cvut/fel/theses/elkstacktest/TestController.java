package cz.strazovan.cvut.fel.theses.elkstacktest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @GetMapping
    public String get() {
        logger.trace("trace log");
        return "hello there.";
    }
}
