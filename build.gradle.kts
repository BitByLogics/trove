plugins {
    id("java-library")
    id("maven-publish")
    id("com.vanniktech.maven.publish") version "0.30.0"
}

group = "net.goldenstack.trove"
version = "4.0"

repositories {
    mavenCentral()
}

dependencies {
    api("org.jetbrains:annotations:24.0.1")

    val minestom = "net.minestom:minestom:2025.12.20-1.21.11"

    compileOnly(minestom)
    compileOnly("it.unimi.dsi:fastutil:8.5.18")

    testImplementation(minestom)

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

mavenPublishing {
    repositories {
        mavenLocal()
    }

    coordinates("net.goldenstack", "trove", version.toString())

    pom {
        name.set("trove")
        description.set("Loot table parser and evaluator for Minestom")
        url.set("https://github.com/goldenstack/trove")
        licenses {
            license {
                name.set("MIT")
                url.set("https://github.com/goldenstack/trove/blob/master/LICENSE")
            }
        }
        developers {
            developer {
                id.set("goldenstack")
                name.set("GoldenStack")
                email.set("git@goldenstack.net")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/goldenstack/trove.git")
            developerConnection.set("scm:git:git@github.com:goldenstack/trove.git")
            url.set("https://github.com/goldenstack/trove")
        }
    }
}
