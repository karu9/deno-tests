package com.example.deno.com.github.karu9.denotests

import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType

class DenoTestRunConfigurationFactory(type: ConfigurationType) : ConfigurationFactory(type) {
    override fun createTemplateConfiguration(project: com.intellij.openapi.project.Project) =
        DenoTestRunConfiguration(project, this, "Deno Test")
}