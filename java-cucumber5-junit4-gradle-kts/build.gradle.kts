import io.qameta.allure.gradle.AllureExtension

plugins {
    java
    maven
    id("io.qameta.allure") version "2.8.1"
}

group "io.qameta.allure.examples"
version 1.0

val allureVersion = "2.13.5"
val junit4Version = "4.12"
val cucumberVersion = "5.7.0"

tasks.withType(JavaCompile::class) {
    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
    targetCompatibility = "${JavaVersion.VERSION_1_8}"
    options.encoding = "UTF-8"
}

//tasks.withType(JavaTestCompile::class) {
//    sourceCompatibility = "${JavaVersion.VERSION_1_8}"
//    targetCompatibility = "${JavaVersion.VERSION_1_8}"
//    options.encoding = "UTF-8"
//}

configure<AllureExtension> {
    autoconfigure = false
    aspectjweaver = true
    version = allureVersion

    clean = true

    useJUnit4 {
        version = allureVersion
    }
}

tasks.withType(Test::class) {
    ignoreFailures = true
    useJUnit {

    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation("io.qameta.allure:allure-cucumber5-jvm:$allureVersion")

    testImplementation("io.cucumber:cucumber-junit:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")

    testImplementation("junit:junit:$junit4Version")
    testImplementation("org.slf4j:slf4j-simple:1.7.30")
}
