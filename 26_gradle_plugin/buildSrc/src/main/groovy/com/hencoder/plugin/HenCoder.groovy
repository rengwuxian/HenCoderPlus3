package com.hencoder.plugin

import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class HenCoder implements Plugin<Project> {
    @Override
    void apply(Project project) {
        def extension = project.extensions.create('hencoder', HenCoderExtension)
        project.afterEvaluate {
            println "Hi ${extension.name}"
        }
        def transform = new HenCoderTransform()
        def baseExtension = project.extensions.getByType(BaseExtension)
        baseExtension.registerTransform(transform)
    }
}
