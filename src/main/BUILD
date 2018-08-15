java_library(
    name = "bazeltest_api",
    srcs = glob(["java/com/talios/bazeltest/api/**/*.java"]),
    plugins = ["//:derive4j_plugin"],
    deps = ["@derive4j_annotation//jar", "@javaslang//jar"],
    visibility = ["//visibility:public"])

java_library(
    name = "bazeltest_impl",
    srcs = glob(["java/com/talios/bazeltest/impl/**/*.java"]),
    plugins = ["//:dagger_compiler_plugin"],
    deps = [
      ":bazeltest_api",
      "@dagger//jar",
      "@flogger//jar",
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
      "@flogger//jar",
      "@javapoet//jar"
    ],
    runtime_deps = [
      "@dagger//jar",
      "@flogger_system_backend//jar"
    ],
    main_class = "com.talios.bazeltest.Main")
