package com.talios.bazeltest;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;
import com.talios.bazeltest.api.Greetings;
import com.talios.bazeltest.impl.DaggerGreetingComponent;
import com.talios.bazeltest.impl.GreetingComponent;
import javaslang.collection.List;
import javaslang.control.Try;

import java.io.IOException;

import javax.lang.model.element.Modifier;

public class Main {

  public static void main(String[] args) throws IOException {

    Try<List<String>> vals = Try.of(() -> List.of(new String[] {"one", "two", "three"}));

    vals.forEach(vargs -> System.out.println(vargs.get(1)));

    System.out.println("Hello world.");

    GreetingComponent greeting = DaggerGreetingComponent.create();

    System.out.println(greeting.provideGreeter().greet(Greetings.Military("Mark", "Soldier")));

    // code-gen

    MethodSpec main =
        MethodSpec.methodBuilder("main")
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .returns(void.class)
            .addParameter(String[].class, "args")
            .addJavadoc("hello - generated at $L\n", new java.util.Date().toString())
            .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
            .build();

    TypeSpec helloWorld =
        TypeSpec.classBuilder("HelloWorld")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(main)
            .build();

    JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld).build();

    javaFile.writeTo(System.out);
  }
}
