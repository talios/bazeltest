package com.talios.bazeltest.impl;

import com.talios.bazeltest.api.Greeter;

import javax.inject.Inject;

@Module
public class GreetingModule {

  @Provides
  Greeter provideGreeter() {
    return new Greeter() {
      @Override
      public String greet(String person) {
        return "Hello " + person;
      }
    };
  }

}
