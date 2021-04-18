package nextstep.ladder.src;

public class User {
  private final String name;

  public User (String name) {
    assureNotEmpty(name);
    this.name = name;
  }

  private static void assureNotEmpty(String str) {
    if(str == null || str.equals("")) {
      throw new IllegalArgumentException("null or 빈값이 들어올 수 없습니다.");
    }
  }

  public String name() {
    return name;
  }
}
