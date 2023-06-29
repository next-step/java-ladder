package nextstep.ladder.domain;

public class PlayerName {

  private static final int MIN_LEN = 1;
  private static final int MAX_LEN = 5;

  String name;

  public PlayerName(String name) {
    validate(name);
    this.name = name;
  }

  private void validate(String name) {
    if (name.length() < MIN_LEN || name.length() > MAX_LEN) {
      throw new IllegalArgumentException(String.format("이름의 길이는 %d ~ %d글자 사이어야 합니다. 입력된 값 : %s", MIN_LEN, MAX_LEN, name));
    }
  }

  public String getName() {
    return this.name;
  }
}
