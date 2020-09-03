import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
		jcenter()
	}

	dependencies {
		val kotlinVersion = "1.3.72"
		classpath(kotlin("serialization", version = kotlinVersion))
	}
}

plugins {
	id("org.springframework.boot") version "2.3.3.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "com.jambo.messanger"
version = "0.0.1-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_11

extra["springCloudVersion"] = "Hoxton.SR7"

subprojects {
	repositories {
		mavenCentral()
		maven(url = "http://packages.confluent.io/maven/")
	}

	apply(plugin = "org.jetbrains.kotlin.jvm")

	apply(plugin = "kotlinx-serialization")

	apply {
		plugin("io.spring.dependency-management")
	}

	dependencyManagement {
		imports {
			mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
		}
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-webflux")
		implementation("org.springframework.boot:spring-boot-starter-actuator")
		implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.10.3")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
		implementation("org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.20.0")
		implementation("org.springframework.cloud:spring-cloud-starter-consul-discovery")
		implementation("org.springframework.cloud:spring-cloud-starter-consul-config")
//		implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
//		implementation("org.springframework.boot:spring-boot-starter-batch")
		implementation("org.springframework.kafka:spring-kafka")

		annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

		testImplementation("org.springframework.boot:spring-boot-starter-test") {
			exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		}
		testImplementation("io.projectreactor:reactor-test")
		testImplementation("org.springframework.kafka:spring-kafka-test")
	}

}

allprojects {
	repositories {
		mavenCentral()
		maven(url = "http://packages.confluent.io/maven/")
	}

	java.sourceCompatibility = JavaVersion.VERSION_1_8

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "1.8"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

}
