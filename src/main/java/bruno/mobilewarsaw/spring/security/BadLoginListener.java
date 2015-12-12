package bruno.mobilewarsaw.spring.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class BadLoginListener extends SimpleUrlAuthenticationFailureHandler implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
        Object userName = event.getAuthentication().getPrincipal();
        Object credentials = event.getAuthentication().getCredentials();

        log.debug("  ");
        log.debug("-------------------------------------------------------------");

        log.debug("Failed login using USERNAME [" + userName + "]" + " and PASSWORD: [" + credentials + "]");
        log.debug("-------------------------------------------------------------");
        log.debug("  ");
    }
}
