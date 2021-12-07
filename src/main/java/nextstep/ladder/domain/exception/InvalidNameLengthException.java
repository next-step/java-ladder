package nextstep.ladder.domain.exception;

import static java.lang.String.format;

public class InvalidNameLengthException extends ServiceException {

    public InvalidNameLengthException(int minLength, int maxLength) {
        super(format("이름의 길이는 %d이상 ~ %d이하 이여야 합니다.", minLength, maxLength));
    }

    public InvalidNameLengthException(int minLength) {
        super(format("이름의 길이는 %d 이상이어야 합니다.", minLength));
    }
}
