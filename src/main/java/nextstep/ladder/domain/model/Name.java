package nextstep.ladder.domain.model;

import java.util.Objects;

public class Name {

  private String name;

  public Name(String name) {
    throwIfInvalid(name);

    this.name = name;
  }

  private void throwIfInvalid(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("6글자 넘는 이름은 생성할 수 없습니다.");
    }
  }

  public String getName() {
    return name;
  }
}
