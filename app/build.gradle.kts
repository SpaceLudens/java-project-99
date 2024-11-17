plugins {
    java
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
    id("jacoco")
    id("checkstyle")
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

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<Test> {
    useJUnitPlatform()
}
jacoco {
    toolVersion = "0.8.8" // Версия JaCoCo
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