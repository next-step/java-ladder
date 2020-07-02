package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class HorizonLine {
    private final static int LEFT_SHORT_LINE = -1;
    private final static int RIGHT_SHORT_LINE = 0;

    private final List<Boolean> shortLines = new ArrayList<>();

    public HorizonLine(int positionCount, ShortLineEnableJudge judge) {
        validateMinimumPosition(positionCount);
        for (int i = 0; i < positionCount - 1; i++) {
            shortLines.add(isEnable(Position.of(i), judge));
        }
    }

    private boolean isEnable(Position position, ShortLineEnableJudge enableJudge) {
        if (isEnabledShortLineOfLeft(position)) {
            return false;
        }
        return enableJudge.isEnable();
    }

    public int getShortLineCount() {
        return shortLines.size();
    }

    protected boolean isEnabledShortLineOfLeft(Position position) {
        validatePositionRange(position);
        final int shortLineIndex = position.get() + LEFT_SHORT_LINE;
        if (shortLineIndex < 0) {
            return false;
        }
        return shortLines.get(shortLineIndex);
    }

    protected boolean isEnabledShortLineOfRight(Position position) {
        validatePositionRange(position);
        final int shortLineIndex = position.get() + RIGHT_SHORT_LINE;
        if (shortLineIndex >= shortLines.size()) {
            return false;
        }
        return shortLines.get(shortLineIndex);
    }

    private void validatePositionRange(Position position) {
        if (position.get() < 0 || position.get() > shortLines.size()) {
            throw new IllegalArgumentException("시작할 수 있는 사디리 Position 을 벗어났습니다.");
        }
    }

    private void validateMinimumPosition(int positionCount) {
        if (positionCount - 1 <= 0) {
            throw new IllegalArgumentException("최소 2개 이상의 사다리 참여을 위한 포지션이 필요합니다.");
        }
    }

}
