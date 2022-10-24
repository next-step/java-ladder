package ladder.exception.person;

import ladder.exception.LadderException;

public class PersonNameLengthException extends LadderException {

    public PersonNameLengthException(int length) {
        super("사람 이름은 최대 " + length + "글자까지 부여할 수 있습니다.");
    }
}
