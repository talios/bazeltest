package com.talios.bazeltest.impl;

import com.talios.bazeltest.api.Greeter;
import com.talios.bazeltest.api.Greeting;
import com.talios.bazeltest.api.Greetings;
import dagger.Module;
import dagger.Provides;
import java.util.function.Function;
import com.google.common.flogger.FluentLogger;

@Module
public class GreetingModule {

  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

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
        logger.atInfo().log("Found greeting for: %s", Greetings.getName(greeting));
        return formatter.apply(greeting);
      }
    };
  }
}
