# Top level module

# Dagger dependency injection declaration, note dagger
# requires it's own, different version of javapoet for code
# generation than the one we're currently using in this
# simple, sample project.

java_plugin(
    name = "dagger_compiler_plugin",
    generates_api = True,
    processor_class = "dagger.internal.codegen.ComponentProcessor",
    visibility = ["//visibility:public"],
    deps = [
        "@dagger//jar",
        "@dagger_compiler//jar",
        "@dagger_javapoet//jar",
        "@dagger_producers//jar",
        "@dagger_spi//jar",
        "@errorprone_javac//jar",
        "@google_java_format//jar",
        "@guava//jar",
        "@javax_inject//jar",
    ],
)

# Annotation processor for Derive4j - ADT generator.

java_plugin(
    name = "derive4j_plugin",
    generates_api = True,
    processor_class = "org.derive4j.processor.DerivingProcessor",
    visibility = ["//visibility:public"],
    deps = [
        "@derive4j//jar",
        "@derive4j_annotation//jar",
        "@derive4j_processor_api//jar",
        "@javapoet//jar",
    ],
)
