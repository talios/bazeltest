package com.talios.bazeltest;

import com.talios.bazeltest.impl.GreetingComponent;
import com.talios.bazeltest.impl.DaggerGreetingComponent;
import javaslang.collection.List;
import javaslang.control.Try;

public class Main {
  
  public static void main(String[] args) {
    
    Try<List<String>> vals = Try.of(() -> List.of(new String[] {"one", "two", "three"}));

    vals.forEach(vargs -> System.out.println(vargs.get(1)));

    System.out.println("Hello world.");
    
    
    GreetingComponent greeting = DaggerGreetingComponent.create();
    
    System.out.println(greeting.provideGreeter().greet("Mark"));
        

    // code-gen
    
//    MethodSpec main = MethodSpec.methodBuilder("main")
//        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
//        .returns(void.class)
//        .addParameter(String[].class, "args")
//        .addJavadoc("// hello - generated at $L", new java.util.Date().toString())
//        .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
//        .build();
//
//    TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
//        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
//        .addMethod(main)
//        .build();
//
//    JavaFile javaFile = JavaFile.builder("com.example.helloworld", helloWorld)
//        .build();
//
//
//    Try.of(() -> {
//      javaFile.writeTo(System.out);
//      return null;
//    });
//


  }  
  
}
