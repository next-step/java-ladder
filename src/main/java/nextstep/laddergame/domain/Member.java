package nextstep.laddergame.domain;

import nextstep.laddergame.util.StringUtils;

public class Member {

  private String name;

  public Member(String name) {
    StringUtils.checkNullOrBlank(name);

    this.name = name;
  }
}
