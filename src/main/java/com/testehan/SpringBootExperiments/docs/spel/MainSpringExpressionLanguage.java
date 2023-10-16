package com.testehan.SpringBootExperiments.docs.spel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import java.io.IOException;
import java.util.GregorianCalendar;

public class MainSpringExpressionLanguage {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // i want to have the main method only working with beans from this package, not other packages
        ctx.scan("com.testehan.SpringBootExperiments.docs.spel");
        ctx.refresh();          // this is important :)



        basicExamples();

        rootObjectGetProperty();

        injectingSystemPropertiesMentionedViaSpEL(ctx);


    }

    private static void injectingSystemPropertiesMentionedViaSpEL(AnnotationConfigApplicationContext ctx) {
        FieldValueTestBean fieldValueTestBean = ctx.getBean(FieldValueTestBean.class);
        System.out.println(fieldValueTestBean.getUserName());
    }

    private static void rootObjectGetProperty() {
        // Create and set a calendar
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        // The constructor arguments are name, birthday, and nationality.
        Inventor tesla = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name"); // Parse name as an expression
        String name = (String) exp.getValue(tesla);
        // name == "Nikola Tesla"
        System.out.println(name);
        exp = parser.parseExpression("name == 'Nikola Tesla'");
        boolean result = exp.getValue(tesla, Boolean.class);
        // result == true
        System.out.println(result);
    }

    private static void basicExamples() {
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);

        Expression exp2= parser.parseExpression("'Hello World'.bytes.length");
        int length = (Integer) exp2.getValue();
        System.out.println(length);

        // Note the use of the generic method: public <T> T getValue(Class<T> desiredResultType). Using this
        // method removes the need to cast the value of the expression to the desired result type
        Expression exp3 = parser.parseExpression("new String('hello world').toUpperCase()");
        String message2 = exp3.getValue(String.class);
        System.out.println(message2);
    }
}
