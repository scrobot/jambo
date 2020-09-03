import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
	plugin("io.spring.dependency-management")
}

apply {
	plugin("org.springframework.boot")
}

group = "com.jambo.messanger.panel"
version = "0.0.1-SNAPSHOT"

repositories {
	mavenCentral()
}

dependencies {
	implementation("de.codecentric:spring-boot-admin-starter-client:2.3.0")
	implementation("de.codecentric:spring-boot-admin-starter-server:2.3.0")
}
