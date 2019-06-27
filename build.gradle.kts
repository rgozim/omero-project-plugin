plugins {
    groovy
    `kotlin-dsl`
    `java-gradle-plugin`
    id("org.openmicroscopy.artifact") version ("5.5.2-SNAPSHOT")
}

project.group = "org.openmicroscopy"
version = "5.5.2-SNAPSHOT"

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
    implementation("org.openmicroscopy:omero-artifact-plugin:5.5.2-SNAPSHOT")
    implementation("org.openmicroscopy:omero-reckon-plugin:5.5.2-SNAPSHOT")
}

gradlePlugin {
    plugins {
        // Plugins for gradle plugins
        register("plugin-project-plugin") {
            id = "org.openmicroscopy.plugin-project"
            implementationClass = "org.openmicroscopy.project.PluginProjectPlugin"
        }
        register("project-plugin") {
            id = "org.openmicroscopy.project"
            implementationClass = "org.openmicroscopy.project.ProjectPlugin"
        }
    }
}
