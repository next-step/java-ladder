package nextstep.ladder.domain;

public class Participant {

  String name;

  public Participant(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("이름을 최대5글자까지 부여할 수 있습니다.");
    }
  }

  public void print() {
    System.out.printf("%-6s", name);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Participant)) return false;
    Participant that = (Participant) o;
    return name.equals(that.name);
  }

  @Override
  public int hashCode() {
    return name.hashCode();
  }

  public boolean matchName(String name) {
    return this.name.equals(name);
  }

  public String value() {
    return this.name;
  }
}
