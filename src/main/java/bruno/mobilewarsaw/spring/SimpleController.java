package bruno.mobilewarsaw.spring;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimpleController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    String home() {
        return "Hello Mobile Warsaw!";
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    String securityHazard(@PathVariable String name) {
        return "Hello " + name + "!";
    }

}
