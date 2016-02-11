java_plugin(name="dagger_compiler_plugin",
  deps = ["@dagger_compiler//jar", "@guava//jar"],
  processor_class = "dagger.internal.codegen.ComponentProcessor")


java_library(
    name = "bazeltest_api",
    srcs = glob(["java/com/talios/bazeltest/api/**/*.java"])
)

java_library(
    name = "bazeltest_impl",
    srcs = glob(["java/com/talios/bazeltest/impl/**/*.java"]),
    plugins = [":dagger_compiler_plugin"],
	  runtime_deps = [
      ":bazeltest_api",
      "@javaslang//jar",
      "@javapoet//jar",
      "@guava//jar",
      "@dagger//jar",
      "@dagger_compiler//jar",
      "@javax_inject//jar"
	]
)

java_binary(
    name = "bazeltest",
    srcs = glob(["java/com/talios/bazeltest/Main.java"]),
    runtime_deps = [
      ":bazeltest_api",
      ":bazeltest_impl",
      "@dagger//jar",
      "@guava//jar",
      "@javaslang//jar",
      "@javapoet//jar"
    ],
    main_class = "com.talios.bazeltest.Main",
)

