package nextstep.ladder.step4.exception;

import org.omg.CORBA.PRIVATE_MEMBER;

public class ArgumentNullPointerException extends NullPointerException {

    private static final String MESSAGE = "값이 존재하지 않습니다.";

    public ArgumentNullPointerException() {
        super(MESSAGE);
    }

}
