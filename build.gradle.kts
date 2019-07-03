plugins {
    groovy
    `kotlin-dsl`
    `java-gradle-plugin`
    id("additional-artifacts-plugin")
    id("functional-test-plugin")
    id("plugin-publishing-plugin")
}

group = "org.openmicroscopy"

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    mavenLocal()
    jcenter()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation("org.jfrog.buildinfo:build-info-extractor-gradle:4.9.3")
    implementation("org.ajoberstar.reckon:reckon-gradle:latest.release")

    api(fileTree("$projectDir/buildSrc/build/libs").matching {
        include("*.jar")
    })
}

gradlePlugin {
    plugins {
        // Plugins for gradle plugins
        register("plugin-project-plugin") {
            id = "org.openmicroscopy.plugin-project"
            implementationClass = "org.openmicroscopy.PluginProjectPlugin"
        }
    }
}
