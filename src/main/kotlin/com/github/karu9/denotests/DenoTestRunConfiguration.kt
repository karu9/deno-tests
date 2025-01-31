package com.example.deno.com.github.karu9.denotests

import com.example.deno.DenoTestSettingsEditor
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationBase
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class DenoTestRunConfiguration(
    project: Project,
    factory: DenoTestRunConfigurationFactory,
    name: String
) : RunConfigurationBase<Project>(project, factory, name) {
    override fun getState(executor: com.intellij.execution.Executor, env: ExecutionEnvironment): RunProfileState? {
        return DenoTestRunProfileState(env)
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return DenoTestSettingsEditor()  // ✅ Now implemented
    }
}