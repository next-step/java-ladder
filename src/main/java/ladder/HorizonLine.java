package ladder;

import java.util.ArrayList;
import java.util.List;

public class HorizonLine {

    private List<Boolean> shortLines = new ArrayList<>();

    public HorizonLine(int positionCount, ShortLineEnableJudge judge) {
        validateMinimumPosition(positionCount);
        for (int i = 0; i < positionCount - 1; i++) {
            shortLines.add(isEnable(i, judge));
        }
    }

    private boolean isEnable(int position, ShortLineEnableJudge enableJudge) {
        if(isEnabledShortLineOfLeft(position)) {
            return false;
        }
        return enableJudge.isEnable();
    }

    public int getShortLineCount() {
        return shortLines.size();
    }

    public boolean isEnabledShortLineOfLeft(int position) {
        validatePositionRange(position);
        final int shortLineIndex = position - 1;
        if(shortLineIndex < 0) {
            return false;
        }
        return shortLines.get(shortLineIndex);
    }

    public boolean isEnabledShortLineOfRight(int position) {
        validatePositionRange(position);
        final int shortLineIndex = position;
        if(shortLineIndex >= shortLines.size()) {
            return false;
        }
        return shortLines.get(shortLineIndex);
    }

    private void validatePositionRange(int position) {
        if(position < 0 || position > shortLines.size()) {
            throw new IllegalArgumentException("시작할 수 있는 사디리 Position 을 벗어났습니다.");
        }
    }

    private void validateMinimumPosition(int positionCount) {
        if(positionCount - 1 <= 0) {
            throw new IllegalArgumentException("최소 2개 이상의 사다리 참여을 위한 포지션이 필요합니다.");
        }
    }

}
