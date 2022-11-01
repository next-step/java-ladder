package ladder.exception.person;

import ladder.exception.LadderException;

public class PersonNotFoundException extends LadderException {
    public PersonNotFoundException() {
        super("사람 찾기에 실패했습니다.");
    }
}
