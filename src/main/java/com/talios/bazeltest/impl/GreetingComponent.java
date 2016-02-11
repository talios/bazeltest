package com.talios.bazeltest.impl;

import com.talios.bazeltest.api.Greeter;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = GreetingModule.class )
public interface GreetingComponent {

  Greeter provideGreeter();

}
