package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int MIN_START_POSITION_COUNT = 2;

    private final List<HorizonLine> horizonLines = new ArrayList<>();

    public Ladder(LadderHeight height, int positionCount) {
       this(height, positionCount, () -> new Random().nextBoolean());
    }

    public Ladder(LadderHeight height, int positionCount, ShortLineEnableJudge shortLineEnableJudge) {
        validateMinPositionCount(positionCount);
        createHorizonLine(height, positionCount, shortLineEnableJudge);
    }

    public void validateMinPositionCount(int positionCount) {
        if (positionCount < MIN_START_POSITION_COUNT) {
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

    public boolean isEnabledShortLineOfRight(int heightIndex, int position) {
        return horizonLines.get(heightIndex).isEnabledShortLineOfRight(position);
    }

    public boolean isEnabledShortLineOfLeft(int heightIndex, int position) {
        return horizonLines.get(heightIndex).isEnabledShortLineOfLeft(position);
    }

    public int getShortLineCountInHorizonLine(int heightIndex) {
        return horizonLines.get(heightIndex).getShortLineCount();
    }
}