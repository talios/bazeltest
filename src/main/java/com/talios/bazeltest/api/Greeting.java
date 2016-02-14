package com.talios.bazeltest.api;

import org.derive4j.Data;
import org.derive4j.Derive;
import org.derive4j.Flavour;
import org.derive4j.Visibility;

@Data(value = @Derive(withVisibility = Visibility.Same), flavour = Flavour.Javaslang)
public abstract class Greeting {

  public interface Cases<R> {

    R SimpleGreeting(String name);
    R ProfessionalGreeting(String name);

  }

  public abstract <R> R match(Cases<R> cases);

}
