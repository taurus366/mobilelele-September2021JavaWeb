package bg.softuni.thymeleaf;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.context.Context;

public class ThymeLeafDemo {

    public static void main(String[] args) {


        ITemplateResolver resolver = new ClassLoaderTemplateResolver();

        TemplateEngine templateEngine = new TemplateEngine();

        templateEngine.setTemplateResolver(resolver);

        Context context = new Context();
        context.setVariable("personToGreet", "banda");


        String result = templateEngine.process("test.html", context);

        System.out.println(result);
    }
}
