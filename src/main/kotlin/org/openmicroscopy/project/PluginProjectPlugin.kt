package org.openmicroscopy.project

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.*
import org.gradle.plugin.devel.plugins.JavaGradlePluginPlugin
import org.openmicroscopy.artifact.ArtifactPlugin

class PluginProjectPlugin : Plugin<Project> {
    override fun apply(project: Project): Unit = project.run {
        apply<JavaGradlePluginPlugin>()
        apply<ArtifactPlugin>()
        apply<PluginReleasePlugin>()
    }
}