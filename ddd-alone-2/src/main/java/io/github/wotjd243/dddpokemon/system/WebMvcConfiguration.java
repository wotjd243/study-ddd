package io.github.wotjd243.dddpokemon.system;

import io.github.wotjd243.dddpokemon.security.LoginUserArgumentResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

public class WebMvcConfiguration implements WebMvcConfigurer {
    @Bean
    public LoginUserArgumentResolver loginUserArgumentResolver() {
        return new LoginUserArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(final List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(loginUserArgumentResolver());
    }
}
