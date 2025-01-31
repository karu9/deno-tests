package com.example.deno.com.github.karu9.denotests

import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.icons.AllIcons

class DenoTestRunConfigurationType : ConfigurationTypeBase(
    "DenoTestRunConfiguration",
    "Deno Test",
    "Run a single Deno test",
    AllIcons.RunConfigurations.Junit
) {
    init {
        addFactory(DenoTestRunConfigurationFactory(this))
    }

    companion object {
        val INSTANCE = DenoTestRunConfigurationType()
    }
}
