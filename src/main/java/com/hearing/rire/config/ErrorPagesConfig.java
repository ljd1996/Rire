package com.hearing.rire.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * Create by hearing on 19-4-14
 */

@Configuration
public class ErrorPagesConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");

        registry.addErrorPages(e404, e500,
                new ErrorPage(HttpStatus.BAD_REQUEST, "/error/"),
                new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/"),
                new ErrorPage(HttpStatus.PAYMENT_REQUIRED, "/error/"),
                new ErrorPage(HttpStatus.FORBIDDEN, "/error/"),
                new ErrorPage(HttpStatus.BAD_GATEWAY, "/error/"),
                new ErrorPage(HttpStatus.SERVICE_UNAVAILABLE, "/error/"),
                new ErrorPage(HttpStatus.GATEWAY_TIMEOUT, "/error/"),
                new ErrorPage(HttpStatus.HTTP_VERSION_NOT_SUPPORTED, "/error/"));
    }
}
