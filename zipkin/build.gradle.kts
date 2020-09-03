import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
	plugin("io.spring.dependency-management")
}

apply {
	plugin("org.springframework.boot")
}

group = "com.jambo.messanger.panel"
version = "0.0.1-SNAPSHOT"

dependencies {
	implementation("org.springframework.cloud:spring-cloud-starter-zipkin")
	implementation("org.springframework.cloud:spring-cloud-sleuth-zipkin-stream")
}