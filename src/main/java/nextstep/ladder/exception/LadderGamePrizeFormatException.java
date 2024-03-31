package nextstep.ladder.exception;

import nextstep.ladder.domain.LadderGamePrize;

import java.text.MessageFormat;

public class LadderGamePrizeFormatException extends IllegalArgumentException {

    public LadderGamePrizeFormatException(String prize) {
        super(MessageFormat.format("사다리 게임 상금 형식은 \"{0}\" 또는 정수 문자열 입니다. (입력된 상금: {1})", LadderGamePrize.MISS, prize));
    }

}
