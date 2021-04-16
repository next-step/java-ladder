package nextstep.laddergame.domain;

import java.util.Objects;

public class Member {

  private final String name;

  public Member(String name) {
    validate(name);
    this.name = name;
  }

  private static void validate(String memberName) {
    hasNull(memberName);
  }

  private static void hasNull(String memberName) {
    if(memberName == null || memberName.trim().length() == 0) {
      throw new IllegalArgumentException("ERROR : 이름에는 Null을 포함할 수 없습니다.");
    }
  }

  public String name() {
    return this.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Member)) {
      return false;
    }
    Member member = (Member) o;
    return Objects.equals(name, member.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}
