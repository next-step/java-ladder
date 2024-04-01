package nextstep.ladder.exception;

import java.text.MessageFormat;

public class PrizesSizeException extends IllegalArgumentException {
    public PrizesSizeException(int numberOfParticipant, int prizesSize) {
        super(MessageFormat.format("참가자 수와 실행 결과 수는 동일해야 합니다. (참가자 수: {0}, 입력된 실행 결과 수: {1}", numberOfParticipant, prizesSize));
    }
}
