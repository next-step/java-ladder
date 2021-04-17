package ladder.domain;

import java.util.Map;

public final class LadderResultBoard {

    private final Map<String, String> resultBoard;

    public LadderResultBoard(Map<String, String> resultBoard) {
        this.resultBoard = resultBoard;
    }

    public static final LadderResultBoard of(Map<String, String> resultBoard) {
        return new LadderResultBoard(resultBoard);
    }
}
