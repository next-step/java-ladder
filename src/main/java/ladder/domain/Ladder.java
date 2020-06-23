package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int MIN_START_POSITION_COUNT = 2;

    private final List<HorizonLine> horizonLines = new ArrayList<>();

    public Ladder(LadderHeight height, int startPositionCount) {
       this(height, startPositionCount, () -> new Random().nextBoolean());
    }

    public Ladder(LadderHeight height, int startPositionCount, ShortLineEnableJudge shortLineEnableJudge) {
        validateMinPositionCount(startPositionCount);
        createHorizonLine(height, startPositionCount, shortLineEnableJudge);
    }

    public void validateMinPositionCount(int startPositionCount) {
        if (startPositionCount < MIN_START_POSITION_COUNT) {
            throw new IllegalArgumentException("사다리를 시작하기 위해서는 2명 이상의 사용자가 필요합니다.");
        }
    }

    public int getHeight() {
        return horizonLines.size();
    }

    private void createHorizonLine(LadderHeight height, int statPositionCount, ShortLineEnableJudge shortLineEnableJudge) {
        for (int i = 0; i < height.get(); i++) {
            horizonLines.add(new HorizonLine(statPositionCount, shortLineEnableJudge));
        }
    }

    public boolean isEnabledShortLineOfRight(int heightIndex, int  startPosition) {
        return horizonLines.get(heightIndex).isEnabledShortLineOfRight(startPosition);
    }

    public boolean isEnabledShortLineOfLeft(int heightIndex, int startPosition) {
        return horizonLines.get(heightIndex).isEnabledShortLineOfLeft(startPosition);
    }

    public int getShortLineCountInHorizonLine(int heightIndex) {
        return horizonLines.get(heightIndex).getShortLineCount();
    }
}