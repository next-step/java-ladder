package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.exception.ServiceException;

import static java.lang.String.format;

public class InvalidNameLengthException extends ServiceException {

    private static final String FORMATTED_MESSAGE = "이름의 길이는 %d ~ %d 여야 합니다.";

    public InvalidNameLengthException(int minLength, int maxLength) {
        super(format(FORMATTED_MESSAGE, minLength, maxLength));
    }
}
