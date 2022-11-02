package ladder.exception.person;

import ladder.exception.LadderException;

public class IllegalPersonNameException extends LadderException {

    public IllegalPersonNameException() {
        super("사람 이름은 null이거나 5글자 이상일 수 없습니다.");
    }
}
