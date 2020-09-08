package com.jambo.messanger.auth

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity

import org.springframework.security.web.server.SecurityWebFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.util.List


@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
open class SecurityConfiguration {

    @Bean
    open fun securityWebFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain = http
        .authorizeExchange()
        .anyExchange()
        .authenticated()
        .and()
        .build()

//    @Bean
//    open fun corsConfigurationSource() = CorsConfiguration().apply {
//        allowedOrigins = listOf("*")
//        maxAge = 3600L
//        addAllowedMethod("*")
//        addAllowedHeader("*")
//    }.let { corsConfig ->
//        UrlBasedCorsConfigurationSource()
//            .apply { registerCorsConfiguration("/**", corsConfig) }
//    }


}