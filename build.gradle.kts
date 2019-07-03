plugins {
    groovy
    `kotlin-dsl`
    `java-gradle-plugin`
    id("org.openmicroscopy.additional-repositories")
    id("org.openmicroscopy.functional-test")
    id("org.openmicroscopy.plugin-publishing")
}

project.group = "org.openmicroscopy"

// Project properties can be accessed via delegation
val omeroArtifactVersion: String by project

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
    implementation("org.openmicroscopy:omero-artifact-plugin:$omeroArtifactVersion")
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
