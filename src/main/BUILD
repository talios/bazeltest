java_plugin(
  name="dagger_compiler_plugin",
  generates_api=True,
  deps = ["@dagger//jar", "@dagger_compiler//jar", "@dagger_producers//jar", "@dagger_javapoet//jar", "@javax_inject//jar",
          "@guava//jar", "@google_java_format//jar", "@errorprone_javac//jar"],
  processor_class = "dagger.internal.codegen.ComponentProcessor")

java_plugin(
  name="derive4j_plugin",
  generates_api=True,
  deps = ["@derive4j//jar", "@derive4j_annotation//jar", "@derive4j_processor_api//jar", "@javapoet//jar"],
  processor_class = "org.derive4j.processor.DerivingProcessor")

java_library(
    name = "bazeltest_api",
    srcs = glob(["java/com/talios/bazeltest/api/**/*.java"]),
    plugins = [":derive4j_plugin"],
    deps = ["@derive4j_annotation//jar", "@javaslang//jar"],
    visibility = ["//visibility:public"])

java_library(
    name = "bazeltest_impl",
    srcs = glob(["java/com/talios/bazeltest/impl/**/*.java"]),
    plugins = [":dagger_compiler_plugin"],
    deps = [
      ":bazeltest_api",
      "@dagger//jar",
      "@javax_inject//jar"
    ],
	visibility = ["//visibility:public"])

java_binary(
    name = "bazeltest",
    srcs = glob(["java/com/talios/bazeltest/Main.java"]),
    deps = [
      ":bazeltest_api",
      ":bazeltest_impl",
      "@javaslang//jar",
      "@javapoet//jar"
    ],
    runtime_deps = [
      "@dagger//jar"
    ],
    main_class = "com.talios.bazeltest.Main")
