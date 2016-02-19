package com.talios.bazeltest.api;

import org.derive4j.Data;
import org.derive4j.Derive;
import org.derive4j.Flavour;
import org.derive4j.Visibility;

@Data(value = @Derive(make = {}), flavour = Flavour.Javaslang)
public abstract class Greeting {

  public interface Cases<R> {

    R Casual(String name);
    R Professional(String name);
    R Military(String name, String rank);

  }

  public abstract <R> R match(Cases<R> cases);

}
