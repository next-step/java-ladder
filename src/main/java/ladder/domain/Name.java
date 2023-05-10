package ladder.domain;

public class Name {

  private final String name;

  public Name(String name) {
    validateLength(name);
    this.name = name;
  }

  private void validateLength(String name) {
    if (isOverLength(name)){
      throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
    }
  }

  private boolean isOverLength(String name) {
    return name.length() > 5;
  }

}
