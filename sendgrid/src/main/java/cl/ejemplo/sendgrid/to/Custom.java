package cl.ejemplo.sendgrid.to;

import java.util.List;

public class Custom {
    private List<Personalizations> personalizations;
    private From from;
    private String subject;
    private String templateId;

    public From getFrom() {
        return from;
    }

    public void setFrom(From from) {
        this.from = from;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Personalizations> getPersonalizations() {
        return personalizations;
    }

    public void setPersonalizations(List<Personalizations> personalizations) {
        this.personalizations = personalizations;
    }
}
