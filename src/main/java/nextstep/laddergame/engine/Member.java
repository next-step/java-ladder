package nextstep.laddergame.engine;

import java.util.Objects;
import nextstep.laddergame.engine.util.StringUtils;

public class Member {

  private final String name;

  public Member(String name) {
    StringUtils.checkNullOrBlank(name);
    if (name.trim().length() > 5) {
      throw new IllegalArgumentException("사람의 이름은 최대 5글자 까지 부여할 수 있습니다.");
    }

    this.name = name.trim();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Member member = (Member) o;
    return Objects.equals(name, member.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  public String getName() {
    return name;
  }
}
