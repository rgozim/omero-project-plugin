pluginManagement {
    repositories {
        mavenLocal()
        gradlePluginPortal()
    }

    resolutionStrategy {
        eachPlugin {
            // Work around https://github.com/gradle/gradle/issues/1697.
            if (requested.version == null && requested.id.namespace == "org.openmicroscopy") {
                val pluginEnvName =
                        requested.id.name.split('-')
                                .joinToString(separator = "_").toUpperCase() + "_VERSION"
                val propertyName =
                        requested.id.name.split('-')
                                .joinToString(separator = "") { it.capitalize() }
                                .decapitalize() + "Version"

                val version: Any = gradle.rootProject.findProperty(pluginEnvName)
                        ?: gradle.rootProject.findProperty(propertyName)!!

                useVersion(version.toString())
            }
        }
    }
}

rootProject.name = "omero-project-plugin"
