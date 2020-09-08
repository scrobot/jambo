package com.jambo.messanger.users.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
open class ApplicationConfig {

    @Bean
    open fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

}