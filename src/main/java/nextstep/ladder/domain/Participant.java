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
}
