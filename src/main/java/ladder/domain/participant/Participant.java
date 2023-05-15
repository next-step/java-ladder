package ladder.domain.participant;

import java.util.Objects;

public class Participant {

  private final Name name;

  /**
   * 주 생성자
   */
  public Participant(Name name) {
    this.name = name;
  }


  public Name getName() {
    return name;
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


  public boolean isAll() {
    return name.isAll();
  }
}
