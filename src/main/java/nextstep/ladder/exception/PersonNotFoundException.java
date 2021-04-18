package nextstep.ladder.exception;

import nextstep.ladder.domain.Person;

public class PersonNotFoundException extends LadderException {

  public static final String PERSON_NOT_FOUND = "입력하신 사람을 찾을 수 없었습니다. 입력한 사람: ";

  public PersonNotFoundException(Person person) {
    super(PERSON_NOT_FOUND + person.personName());
  }
}
