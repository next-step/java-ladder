package nextstep.laddergame.domain;

import nextstep.laddergame.util.StringUtils;

public class Member {

  private String name;

  public Member(String name) {
    StringUtils.checkNullOrBlank(name);
    if (name.trim().length() > 5) {
      throw new IllegalArgumentException("사람의 이름은 최대 5글자 까지 부여할 수 있습니다.");
    }

    this.name = name;
  }
}
