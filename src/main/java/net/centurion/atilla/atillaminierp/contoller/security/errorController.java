package net.centurion.atilla.atillaminierp.contoller.security;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class errorController{


    @RequestMapping(value = "/500")
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String serverError ( ) {

        return "500";
    }


    @RequestMapping(value = "/404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String not_found ( ) {

        return "404";
    }

    @RequestMapping(value = "/400")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badRequet ( ) {

        return "400";
    }

    @RequestMapping("/403")
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String forbidden ( ) {

        return "403";
    }

    @RequestMapping("/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String unauthorized ( ) {

        return "401";
    }

    @RequestMapping("/408")
    @ResponseStatus(HttpStatus.REQUEST_TIMEOUT)
    public String request_timeout ( ) {

        return "408";
    }

    @RequestMapping("/409")
    @ResponseStatus(HttpStatus.CONFLICT)
    public String conflict ( ) {

        return "409";
    }

    @RequestMapping("/423")
    @ResponseStatus(HttpStatus.LOCKED)
    public String locked ( ) {

        return "423";
    }

    @RequestMapping("/501")
    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)
    public String not_implemented ( ) {

        return "501";
    }

}
