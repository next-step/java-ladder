package nextstep.ladder.exception;

import java.text.MessageFormat;

public class PersonNameLengthExceedException extends IllegalArgumentException {

    public PersonNameLengthExceedException(String name) {
        super(MessageFormat.format("사람의 이름은 5글자를 초과할 수 없습니다. (입력된 이름: {0}, 입력된 글자수: {1})", name, name.length()));
    }
}
