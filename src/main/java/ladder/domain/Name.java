package ladder.domain;

public class Name {

  private final String name;

  /**
   * TODO : 이름이 5글자 이하인지 검증하는 기능을 Interface로 뽑아서 구현해보자. (구현체는 람다 표현식 활용)
   * 이름이 5글자로 받을 수 있다는 요구사항은 충분히 변경 가능성이 있어보인다.
   * 변경 가능성이 있는 부분은 Interface를 통해서 추출해보자
   * 구현체는 람다 표현식을 활용해보자.
   * (우선 하던 기능 마저 하고, 구현해보자 -> Commit 을 좀 더 깔끔하게 가져가고 싶다.)
   */
  public Name(String name) {
    validateLength(name);
    this.name = name;
  }

  private void validateLength(String name) {
    if (name.length() > 5) {
      throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
    }
  }

}
