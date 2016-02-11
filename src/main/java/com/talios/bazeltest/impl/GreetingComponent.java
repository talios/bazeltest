package com.talios.bazeltest.impl;

@Singleton
@Component(modules = GreetingModule.class )
public class GreetingComponent {

  String greet(String person);

}
