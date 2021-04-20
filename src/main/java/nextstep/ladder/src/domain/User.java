package nextstep.ladder.src.domain;

public class User {
  private final String name;

  public User (String name) {
    assureNotEmpty(name);
    checkMaxLength(name);
    this.name = name;
  }

  private static void assureNotEmpty(String name) {
    if(name == null || name.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
  }

  private static void checkMaxLength(String name) {
    if(name.length() > 5) {
      throw new IllegalArgumentException("name 은 5 글자를 넘어갈 수 없습니다.");
    }
  }

  public String name() {
    return name;
  }
}
