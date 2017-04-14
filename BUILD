# Top level module

# Dagger dependency injection declaration, note dagger
# requires it's own, different version of javapoet for code
# generation than the one we're currently using in this
# simple, sample project.

java_plugin(
  name = "dagger_compiler_plugin",
  generates_api = True,
  visibility = ["//visibility:public"],
  deps = ["@dagger//jar", "@dagger_compiler//jar", "@dagger_producers//jar", "@dagger_javapoet//jar", "@javax_inject//jar",
          "@guava//jar", "@google_java_format//jar", "@errorprone_javac//jar"],
  processor_class = "dagger.internal.codegen.ComponentProcessor")

# Annotation processor for Derive4j - ADT generator.

java_plugin(
  name = "derive4j_plugin",
  generates_api = True,
  visibility = ["//visibility:public"],
  deps = ["@derive4j//jar", "@derive4j_annotation//jar", "@derive4j_processor_api//jar", "@javapoet//jar"],
  processor_class = "org.derive4j.processor.DerivingProcessor")
