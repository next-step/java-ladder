package ladderGame.step2.model;

import java.util.Objects;

public class Name {

  private static final int LIMIT_NAME_LENGTH = 5;

  private static final String MSG_ERROR_FAIL_NAME_LENGTH = "사용자명은 최대 5글자까지 가능합니다.";

  private static final String MSG_ERROR_FAIL_NAME_EMPTY = "사용자이름을 입력 해주세요.";

  private final String name;

  public Name(final String name) {
    validation(name);
    this.name = name;
  }

  private void validation(final String name) {
    checkNameLength(name);
    checkNameEmpty(name);
  }

  private void checkNameEmpty(final String name) {
    if(name.isEmpty()){
      throw new IllegalArgumentException(MSG_ERROR_FAIL_NAME_EMPTY);
    }
  }

  private void checkNameLength(final String name) {
    if(name.length() > LIMIT_NAME_LENGTH){
      throw new IllegalArgumentException(MSG_ERROR_FAIL_NAME_LENGTH);
    }
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Name name1 = (Name) o;
    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }
}