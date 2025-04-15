package _9oormthonuniv.springs3store.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("S3 게시글 관리 API")
                        .description("Spring Boot + S3 + JPA 기반 게시글 CRUD API 문서화")
                        .version("v1.0"));
    }
}

