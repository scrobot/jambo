import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply {
	plugin("io.spring.dependency-management")
}

apply {
	plugin("org.springframework.boot")
}

group = "com.jambo.messanger.users"
version = "0.0.1-SNAPSHOT"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-cassandra-reactive")
//	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
//	implementation("io.r2dbc:r2dbc-postgresql")
}
