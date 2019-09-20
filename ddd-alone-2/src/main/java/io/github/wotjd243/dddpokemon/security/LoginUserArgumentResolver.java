package io.github.wotjd243.dddpokemon.security;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private static final String LOGGED_IN_USER = "logged-in-user";

    @Override
    public boolean supportsParameter(final MethodParameter parameter) {
        return parameter.hasMethodAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(
            final MethodParameter parameter,
            final ModelAndViewContainer mavContainer,
            final NativeWebRequest webRequest,
            final WebDataBinderFactory binderFactory
    ) throws Exception {
        return webRequest.getAttribute(LOGGED_IN_USER, RequestAttributes.SCOPE_SESSION);
    }
}
