buildscript {
  def getInputParam = { String name ->
      def envVarName = name.toUpperCase().replace('.', '_').replace('-', '_')
      return System.getProperty(name) ?: System.getenv(envVarName)
  }
  def pluginRepositoryUrl = getInputParam('gradle.plugin-repository.url') ?: 'https://plugins.gradle.org/m2'
  def dependencyGraphPluginVersion = getInputParam('dependency-graph-plugin.version') ?: '1.2.1'

  println "WE GOT HERE AT LEAST!"
  println "Applying dependency graph plugin ${dependencyGraphPluginVersion}"

  repositories {
    maven { url pluginRepositoryUrl }
  }
  dependencies {
    classpath "org.gradle:github-dependency-graph-gradle-plugin:${dependencyGraphPluginVersion}"
  }
}
apply plugin: org.gradle.github.GitHubDependencyGraphPlugin
