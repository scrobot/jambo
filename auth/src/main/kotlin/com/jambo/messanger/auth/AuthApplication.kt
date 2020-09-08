package com.jambo.messanger.auth

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.gateway.filter.factory.HystrixGatewayFilterFactory
import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec
import org.springframework.cloud.gateway.route.builder.PredicateSpec
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean


@SpringBootApplication
open class AuthApplication(
	private val discoveryClient: DiscoveryClient
) {

    @Bean
    open fun routes(builder: RouteLocatorBuilder): RouteLocator = builder.routes()
        .route { p: PredicateSpec ->
            p.path("/get")
                .filters { f: GatewayFilterSpec ->
                    f.addRequestHeader(
						"Hello",
						"World"
					)
                }
                .uri("http://httpbin.org:80")
        }.build()

}

fun main(args: Array<String>) {
    runApplication<AuthApplication>(*args)
}
