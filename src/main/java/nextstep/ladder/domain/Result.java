package nextstep.ladder.domain;

public class Result {

  private String name;

  private Result(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("name.length < 6");
    }
    this.name = name;
  }

  public static Result generate(String name) {
    return new Result(name);
  }

  public String getName() {
    return name;
  }
}
