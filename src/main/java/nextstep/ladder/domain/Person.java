package nextstep.ladder.domain;

public class Person {

  private final String name;
  private final int MAX_NAME_LENGTH = 5;

  public Person(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if( name.length() > MAX_NAME_LENGTH ){
      throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
    }
  }

  public String getName() {
    return name;
  }
}
