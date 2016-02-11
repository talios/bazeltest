java_plugin(name="dagger_compiler_plugin",
  deps = ["@dagger//jar", "@dagger_compiler//jar", "@dagger_producers//jar", "@javax_inject//jar", "@guava//jar"],
  processor_class = "dagger.internal.codegen.ComponentProcessor")


java_library(
    name = "bazeltest_api",
    srcs = glob(["java/com/talios/bazeltest/api/**/*.java"]),
	visibility = ["//visibility:public"]
)

java_library(
    name = "bazeltest_impl",
    srcs = glob(["java/com/talios/bazeltest/impl/**/*.java"]),
    plugins = [":dagger_compiler_plugin"],
    deps = [
      ":bazeltest_api",
      "@dagger//jar",
      "@javax_inject//jar"
    ],
	visibility = ["//visibility:public"]
)

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
    main_class = "com.talios.bazeltest.Main",
)
