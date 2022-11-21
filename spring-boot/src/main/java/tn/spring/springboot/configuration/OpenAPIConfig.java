package tn.spring.springboot.configuration;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.web.bind.annotation.RequestMapping;


@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());
    }

    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());
    }

    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")
                .email("meriemnour.ghozzi@esprit.tn")
                .url("https://www.linkedin.com/in/meriem-nour-ghozzi-9693b11b3/");

        return contact;
    }
    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Contrat API")
                                .pathsToMatch("/addC/**")
                                .pathsToExclude("**")
                                .build();
    }

}
