package domain;

import java.util.Objects;

public class Participant {

  public final static int MAXIMUM_NAME_LENGTH = 5;

  private String name;

  public Participant(String name) {

    if (name == null || name.isEmpty() || name.length() > MAXIMUM_NAME_LENGTH) {
      throw new IllegalArgumentException();
    }
    this.name = name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Participant that = (Participant) o;
    return Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
