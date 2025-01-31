package com.example.deno.com.github.karu9.denotests

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.process.KillableProcessHandler
import com.intellij.execution.configurations.GeneralCommandLine

class DenoTestRunProfileState(env: ExecutionEnvironment) : CommandLineState(env) {
    override fun startProcess(): ProcessHandler {
        val command = GeneralCommandLine("deno", "test")
        return KillableProcessHandler(command)
    }
}