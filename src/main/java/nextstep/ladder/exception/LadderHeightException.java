package nextstep.ladder.exception;

import nextstep.ladder.domain.Ladder;

import java.text.MessageFormat;

public class LadderHeightException extends IllegalArgumentException {

    public LadderHeightException(int height) {
        super(MessageFormat.format("사다리의 최소 높이는 {0} 입니다. (입력된 높이: {1})", Ladder.MIN_LADDER_HEIGHT, height));
    }
}
