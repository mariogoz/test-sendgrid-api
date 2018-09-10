package cl.ejemplo.sendgrid.resource;


import cl.ejemplo.sendgrid.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/v1.0/")
public class EmailResource {

    @Autowired
    EmailService emailService;

    @RequestMapping(value="sendemail",
            method= RequestMethod.GET,
            consumes ="application/json",
            produces = "application/json")
    public ResponseEntity<Void> sendemail()  {

        emailService.sendEmail();

        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value="sendemail/api",
            method= RequestMethod.GET,
            consumes ="application/json",
            produces = "application/json")
    public ResponseEntity<Void> sendemailapi()  {

        emailService.sendEmailapi();

        return new ResponseEntity(HttpStatus.OK);
    }

}
