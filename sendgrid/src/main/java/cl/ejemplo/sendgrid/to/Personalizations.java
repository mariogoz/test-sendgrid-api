package cl.ejemplo.sendgrid.to;

import java.util.List;

public class Personalizations {
    private List<To> to;
    private DynamicTemplateData dynamicTemplateData;


    public List<To> getTo() {
        return to;
    }

    public void setTo(List<To> to) {
        this.to = to;
    }

    public DynamicTemplateData getDynamicTemplateData() {
        return dynamicTemplateData;
    }

    public void setDynamicTemplateData(DynamicTemplateData dynamicTemplateData) {
        this.dynamicTemplateData = dynamicTemplateData;
    }
}
