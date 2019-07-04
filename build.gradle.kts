plugins {
    groovy
    `kotlin-dsl`
    `java-gradle-plugin`
    id("plugin-release")
    id("org.openmicroscopy.additional-artifacts") version("5.5.2")
    id("org.openmicroscopy.plugin-publishing") version("5.5.2")
    id("org.openmicroscopy.functional-test") version("5.5.2")
}

project.group = "org.openmicroscopy"

// Project properties can be accessed via delegation
val omeroArtifactVersion: String by project

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
    implementation("org.openmicroscopy:omero-artifact-plugin:latest.release")
    implementation("org.openmicroscopy:omero-reckon-plugin:latest.release")
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
