package bruno.mobilewarsaw.spring.useraccount;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrincipalExampleController {

    @RequestMapping(value = "/HelloAleksandra", method = RequestMethod.GET)
    String helloAleksandra(Authentication authentication) {
        if (authentication.getName().equals("Aleksandra")) {
            return "Hello " + authentication.getName() + "!  Your role is " + authentication.getAuthorities().toString();
        } else {
            return "You are not Aleksandra!  We don't want you here";
        }
    }

}
