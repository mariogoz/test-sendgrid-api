package cl.ejemplo.sendgrid.service;

import cl.ejemplo.sendgrid.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    EmailUtil emailUtil;

    @Autowired
    RestTemplate restTemplate;

    public void sendEmail() {
        String to = "mario.gonzalez.22@outlook.com";
        String subject = "prueba sendgrid";
        String message = "this is an example";
        emailUtil.sendSimpleMessage(to,subject,message);
    }

    public void sendEmailapi() {
        Version version = getTemplete();

        String url
                = "https://api.sendgrid.com/v3/mail/send";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String key = "Sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        headers.add("Authorization", "Bearer " + key);

        HttpEntity<Custom> httpEntity = new HttpEntity(getCustomData(version), headers);

        Object response =  restTemplate.exchange(url,HttpMethod.POST,httpEntity,Object.class);

    }

    private Version getTemplete() {
        String url
                = "https://api.sendgrid.com/v3/templates/{id}";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String key = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        headers.add("Authorization", "Bearer " + key);
        HttpEntity httpEntity = new HttpEntity( headers);
        String id = "d-xxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
        ResponseEntity<Templete> response =  restTemplate.exchange(url,HttpMethod.GET,httpEntity, Templete.class,id);
        Templete templete = response.getBody();
        System.out.println(templete.getId());
        return templete.getVersions().get(0);
    }

    private Custom getCustomData(Version version) {
        Custom custom = new Custom();

        To to = new To("mario.gonzalez.22@outlook.com");

        List<To> toList = new ArrayList<>();
        toList.add(to);

        List<Personalizations> personalizationsList = new ArrayList<>();
        Personalizations personalizations = new Personalizations();
        personalizations.setTo(toList);
        DynamicTemplateData dynamicTemplateData = new DynamicTemplateData();
        dynamicTemplateData.setId("12345");
        personalizations.setDynamicTemplateData(dynamicTemplateData);
        personalizationsList.add(personalizations);

        From from = new From("noreply@xxxxxxx.cl");

        custom.setTemplateId("d-xxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        custom.setFrom(from);
        custom.setPersonalizations(personalizationsList);
        custom.setSubject(version.getSubject());
        return custom;
    }
}
