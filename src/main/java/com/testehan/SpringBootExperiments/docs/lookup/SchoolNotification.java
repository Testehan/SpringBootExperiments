package com.testehan.SpringBootExperiments.docs.lookup;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


// a prototype bean that we will later inject into a singleton bean

@Component
@Scope("prototype")
public class SchoolNotification {
}
