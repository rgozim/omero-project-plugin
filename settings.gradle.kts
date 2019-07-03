pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }

    resolutionStrategy {
        eachPlugin {
            // Work around https://github.com/gradle/gradle/issues/1697.
            if (requested.version == null && requested.id.namespace == "org.openmicroscopy") {
                val version = gradle.rootProject.properties["omeroArtifactVersion"]
                useModule("org.openmicroscopy:omero-artifact-plugin:$version")
            }
        }
    }
}

rootProject.name = "omero-project-plugin"
