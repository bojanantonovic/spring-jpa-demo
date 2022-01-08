plugins {
    java
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}


group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-autoconfigure:2.6.2")
    implementation("org.springframework.data:spring-data-jpa:2.6.0")
    implementation("javax.persistence:javax.persistence-api:2.2")
    testRuntimeOnly("org.hibernate:hibernate-core:5.6.3.Final")
    testImplementation("org.springframework:spring-test:5.3.14")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testRuntimeOnly("com.h2database:h2:2.0.206")
    testRuntimeOnly("com.microsoft.sqlserver:mssql-jdbc:9.4.1.jre16")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
