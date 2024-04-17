package nextstep.ladder.domain.person;

public class Person {

  private final String name;
  private static final int MAX_NAME_LENGTH = 5;

  public Person(String name) {
    validateName(name);
    this.name = name;
  }

  private void validateName(String name) {
    if( name.length() > MAX_NAME_LENGTH ){
      throw new IllegalArgumentException(String.format("이름은 %d자 이하여야 합니다.", MAX_NAME_LENGTH));
    }
  }

  public String getName() {
    return name;
  }

  public boolean isSameName(String name) {
    return this.name.equals(name);
  }

  public boolean equals(Object obj){
    if(obj != null && obj instanceof Person){
      return this.name.equals(((Person)obj).getName());
    }
    return false;
  }

  public int hashCode(){
    return name.hashCode();
  }

}
