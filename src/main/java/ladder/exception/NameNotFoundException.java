package ladder.exception;

import ladder.domain.participants.Name;

public class NameNotFoundException extends RuntimeException {

    public NameNotFoundException(Name nameToFind) {
        super("해당 이름을 찾을 수 없습니다 : " + nameToFind);
    }
}
