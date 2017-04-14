# Bazel Test Project

This is a simple test project using the [Bazel](http://bazel.io) build tool from Google.

Project deependencies are declared in the `WORKSPACE` file in the root of the repository,
the exmaple provided here declares an custom Apache Maven repository from the `oss.sonatype.org`
which is used to aquire a `SNAPSHOT` release of the Javaslang project.

Unlike Apache Maven or gradle, in Bazel such extennal artifacts are declared as a
_named_ concept for which individual build rules refer to _without_ version information. If you
wish to use multiple versions of a given artifact, it needs to be declared as it's own named
dependency.

When build rules ( found in `BUILD` files ) refer to dependencies, they refer only to
named identifiers, the declaration itself has no knowledge that the dependency comes
from a Maven repository, an generic HTTP/FTP based resource, the local filesytem or something
that was compiled by Bazel itself.
