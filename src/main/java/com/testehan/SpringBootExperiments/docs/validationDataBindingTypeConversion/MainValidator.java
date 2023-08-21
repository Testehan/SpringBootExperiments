package com.testehan.SpringBootExperiments.docs.validationDataBindingTypeConversion;

import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.DataBinder;

import java.util.Locale;

public class MainValidator {

    public static void main(String[] args) {
        Person person = new Person("",100);

        DataBinder dataBinder = new DataBinder(person);
        dataBinder.addValidators(new PersonValidator());
        dataBinder.validate();

        if (dataBinder.getBindingResult().hasErrors()) {
            ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
            messageSource.setBasename("static/internationalization/ValidationMessages");

            dataBinder.getBindingResult().getAllErrors().stream()
                    .forEach(e -> System.err.println(messageSource.getMessage(e, Locale.US)));
        } else {
            System.out.println("No Validation errors");
        }
    }
}
