package nextstep.ladder.domain;

public class Name {
  private static final int MAX_LEN_OF_NAME = 5;
  private String name;
  public Name(String name){
    validate(name);
    this.name = name;
  }
  private void validate(String name){
    if(name.length() > MAX_LEN_OF_NAME) throw new IllegalArgumentException("이름은 최대 5글자까지 부여할 수 있습니다.");
  }
}
