plugins {
    java
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
    id("jacoco")
    checkstyle
    id("io.freefair.lombok") version "8.6"
}

group = "hexlet.code"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

checkstyle {
    toolVersion = "10.0"
    configFile = file("config/checkstyle/checkstyle.xml")
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation ("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")
    implementation ("jakarta.validation:jakarta.validation-api:3.0.2")



}


tasks.withType<Test> {
    useJUnitPlatform()
}
jacoco {
    toolVersion = "0.8.12" // Версия JaCoCo
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport) // Генерация отчета после выполнения тестов
}

tasks.jacocoTestReport {
    dependsOn(tasks.test) // Убедитесь, что тесты выполнены перед созданием отчета
    reports {
        html.required = true
        xml.required = true
        csv.required = false
    }
}