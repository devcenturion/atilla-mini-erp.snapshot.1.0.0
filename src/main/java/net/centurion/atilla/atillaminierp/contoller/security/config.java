package net.centurion.atilla.atillaminierp.contoller.security;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class config implements EmbeddedServletContainerCustomizer{

    @Override
    public void customize (ConfigurableEmbeddedServletContainer container) {
        // TODO Auto-generated method stub
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404"));
        container.addErrorPages(new ErrorPage(HttpStatus.FORBIDDEN, "/403"));
        container.addErrorPages(new ErrorPage(HttpStatus.BAD_REQUEST, "/400"));
        container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED, "/401"));
        container.addErrorPages(new ErrorPage(HttpStatus.REQUEST_TIMEOUT, "/408"));
        container.addErrorPages(new ErrorPage(HttpStatus.CONFLICT, "/409"));
        container.addErrorPages(new ErrorPage(HttpStatus.LOCKED, "/423"));
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_IMPLEMENTED, "/501"));
        container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500"));
    }

}
