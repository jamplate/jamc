plugins {
    kotlin("jvm") version "1.6.10"
    id("maven-publish")
}

group = "org.jamplate"
version = "0.4.0"

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jamplate:jamtree:7f9d47a043")
    implementation("org.jetbrains:annotations:23.0.0")

    testImplementation("org.junit.jupiter:junit-jupiter:5.8.2")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["java"])
                artifactId = "jamc"
            }
        }
    }
}
