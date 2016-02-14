package com.talios.bazeltest.impl;

import com.talios.bazeltest.api.Greeter;
import com.talios.bazeltest.api.Greeting;
import com.talios.bazeltest.api.Greetings;
import dagger.Module;
import dagger.Provides;
import java.util.function.Function;

@Module
public class GreetingModule {

  static final Function<Greeting, String> greetingMessagFn = Greetings.cases()
    .SimpleGreeting(person -> String.format("Hello %s",  person))
    .ProfessionalGreeting(person -> String.format("Good evening Sir %s, how are you?", person));

  @Provides
  Greeter provideGreeter() {
    return new Greeter() {
      @Override
      public String greet(Greeting greeting) {                  
        return greetingMessagFn.apply(greeting);
      }
    };
  }

}
