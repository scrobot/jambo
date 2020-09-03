import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
	plugin("io.spring.dependency-management")
}

apply {
	plugin("org.springframework.boot")
}

group = "com.jambo.messanger.admin"
version = "0.0.1-SNAPSHOT"

dependencies {
	implementation("org.springframework.data:spring-data-cassandra:1.4.1.RELEASE")
	implementation("org.springframework.boot:spring-boot-starter-data-cassandra-reactive")
}