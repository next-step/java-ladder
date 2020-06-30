package laddergame.model;

import java.util.Objects;

public class ResultName {

  private final Name name;

  private ResultName(Name name) {
    this.name = name;
  }

  public static ResultName createBy(String name) {
    return new ResultName(new Name(name));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ResultName that = (ResultName) o;
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return name.toString();
  }
}
