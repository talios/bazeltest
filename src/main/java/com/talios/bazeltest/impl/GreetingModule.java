package com.talios.bazeltest.impl;

import com.talios.bazeltest.api.Greeter;
import com.talios.bazeltest.api.Greeting;
import com.talios.bazeltest.api.Greetings;
import dagger.Module;
import dagger.Provides;
import java.util.function.Function;

@Module
public class GreetingModule {

  @Provides
  Function<Greeting, String> provideGreetingFormatter() {
    return Greetings.cases()
        .Casual(person -> String.format("Hello %s", person))
        .Professional(person -> String.format("Good evening Sir %s, how are you?", person))
        .Military((name, rank) -> String.format("Stand to Attention %s...  at ease.", rank));
  }

  @Provides
  Greeter provideGreeter(Function<Greeting, String> formatter) {
    return new Greeter() {
      @Override
      public String greet(Greeting greeting) {

        System.out.println("Found greeting for: " + Greetings.getName(greeting));

        return formatter.apply(greeting);
      }
    };
  }
}
