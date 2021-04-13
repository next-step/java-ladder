package step2.model.name;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Names {
  private static final String SPLIT_DELIMITER = ",";

  private final List<Name> names;

  private Names(List<Name> names){
    this.names = names;
  }

  public static Names initNames(String names){
    Builder builder = new Builder();

    Arrays.stream(names.split(SPLIT_DELIMITER)).forEach(builder::addName);
    return builder.build();
  }

  public boolean isNameContains(Name name){
    return names.contains(name);
  }

  static class Builder{
    private List<Name> names;

    public Builder(){
      this(new ArrayList<>());
    }

    Builder(List<Name> names){
      this.names = names;
    }

    public Builder addName(String name){
      names.add(new Name(name));
      return this;
    }

    public Names build(){
      names = Collections.unmodifiableList(names);
      return new Names(names);
    }
  }
}
