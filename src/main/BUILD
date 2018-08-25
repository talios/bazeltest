java_library(
    name = "bazeltest_api",
    srcs = glob(["java/com/talios/bazeltest/api/**/*.java"]),
    plugins = ["//:derive4j_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        "@derive4j_annotation//jar",
        "@vavr//jar",
    ],
)

java_library(
    name = "bazeltest_impl",
    srcs = glob(["java/com/talios/bazeltest/impl/**/*.java"]),
    plugins = ["//:dagger_compiler_plugin"],
    visibility = ["//visibility:public"],
    deps = [
        ":bazeltest_api",
        "@dagger//jar",
        "@flogger//jar",
        "@javax_inject//jar",
    ],
)

java_binary(
    name = "bazeltest",
    srcs = glob(["java/com/talios/bazeltest/Main.java"]),
    main_class = "com.talios.bazeltest.Main",
    runtime_deps = [
        "@dagger//jar",
        "@flogger_system_backend//jar",
    ],
    deps = [
        ":bazeltest_api",
        ":bazeltest_impl",
        "@flogger//jar",
        "@javapoet//jar",
        "@vavr//jar",
    ],
)
