package com.testehan.SpringBootExperiments.docs.spel;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.lang.Nullable;

import java.util.Date;
import java.util.GregorianCalendar;

public class Inventor {

    private final Log log = LogFactory.getLog(getClass());

    @Nullable
    private String name;
    private String nationality;
    private String[] inventions;

    private Date birthdate;
    private PlaceOfBirth placeOfBirth;
    public Inventor(String name, String nationality) {
        GregorianCalendar c= new GregorianCalendar();
        this.name = name;
        this.nationality = nationality;
        this.birthdate = c.getTime();
    }
    public Inventor(String name, Date birthdate, String nationality) {
        this.name = name;
        this.nationality = nationality;
        this.birthdate = birthdate;

        log.info("Created new inventor with name " + this.name);
    }
    public Inventor() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public Date getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
    public PlaceOfBirth getPlaceOfBirth() {
        return placeOfBirth;
    }
    public void setPlaceOfBirth(PlaceOfBirth placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setInventions(String[] inventions) {
        this.inventions = inventions;
    }
    public String[] getInventions() {
        return inventions;
    }
}
