package com.example.deno

import com.example.deno.com.github.karu9.denotests.DenoTestRunConfiguration
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.ui.LabeledComponent
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import javax.swing.JComponent

class DenoTestSettingsEditor : SettingsEditor<DenoTestRunConfiguration>() {
    private val component = LabeledComponent.create(TextFieldWithBrowseButton(), "Test File:")

    override fun resetEditorFrom(s: DenoTestRunConfiguration) {
        // Load the configuration into the editor (if needed)
    }

    override fun applyEditorTo(s: DenoTestRunConfiguration) {
        // Save the editor settings to the configuration (if needed)
    }

    override fun createEditor(): JComponent {
        return component
    }
}