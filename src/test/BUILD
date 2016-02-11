java_test(
    name = "tests",
    size = "small",
    srcs = glob(["java/com/talios/bazeltest/*.java"]),
	deps = [
  	  "@junit//jar",
	  "@hamcrest//jar"
	],
    runtime_deps = [
        "//src/main:bazeltest_impl",
    ],
)
