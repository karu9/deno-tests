package com.example.deno.com.github.karu9.denotests

import com.intellij.execution.RunManager
import com.intellij.execution.RunnerAndConfigurationSettings
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.runners.ExecutionEnvironmentBuilder
import com.intellij.execution.runners.ProgramRunner
import com.intellij.openapi.actionSystem.*
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange

class RunDenoTestAction : AnAction("Run Deno Test") {
    override fun actionPerformed(e: AnActionEvent) {
        val project: Project = e.project ?: return
        val editor = e.getData(CommonDataKeys.EDITOR) ?: return
        val document = editor.document

        val caretModel = editor.caretModel
        val lineNumber = caretModel.logicalPosition.line
        val lineText = document.getText(
            TextRange(document.getLineStartOffset(lineNumber), document.getLineEndOffset(lineNumber))
        )

        // Extract the test name from `Deno.test("test name")`
        val testNameRegex = "Deno\\.test\\([\"'](.+?)[\"']".toRegex()
        val match = testNameRegex.find(lineText)
        val testName = match?.groupValues?.get(1) ?: return

        runDenoTest(project, testName)
    }

    private fun runDenoTest(project: Project, testName: String) {
        val command = GeneralCommandLine("deno", "test", "--filter", testName)
        val runManager = RunManager.getInstance(project)
        val settings: RunnerAndConfigurationSettings? = runManager.createConfiguration(
            "Run Deno Test",
            DenoTestRunConfigurationFactory(DenoTestRunConfigurationType())
        )

        settings?.let {
            runManager.addConfiguration(it)
            runManager.selectedConfiguration = it

            val executor = DefaultRunExecutor.getRunExecutorInstance()
            val environment = ExecutionEnvironmentBuilder.create(executor, it).build()
            val runProfile = environment.runProfile  // ✅ Extract RunProfile from ExecutionEnvironment
            ProgramRunner.getRunner(DefaultRunExecutor.EXECUTOR_ID, runProfile)?.execute(environment)
        }
    }
}
