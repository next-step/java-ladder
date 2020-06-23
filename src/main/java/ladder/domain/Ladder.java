package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int MIN_HEIGHT = 2;
    private static final int MIN_START_POSITION_COUNT = 2;

    private final List<HorizonLine> horizonLines = new ArrayList<>();

    public Ladder(int height, int positionCount) {
       this(height, positionCount, () -> new Random().nextBoolean());
    }

    public Ladder(int height, int positionCount, ShortLineEnableJudge shortLineEnableJudge) {
        validateMinHeight(height);
        validateMinPositionCount(positionCount);
        createHorizonLine(height, positionCount, shortLineEnableJudge);
    }


    public void validateMinHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException("사다리 높이는 2이상 이어야 합니다.");
        }
    }

    public void validateMinPositionCount(int positionCount) {
        if (positionCount < MIN_START_POSITION_COUNT) {
            throw new IllegalArgumentException("사다리를 시작하기 위해서는 2명 이상의 사용자가 필요합니다.");
        }
    }

    public int getHeight() {
        return horizonLines.size();
    }

    private void createHorizonLine(int height, int statPositionCount, ShortLineEnableJudge shortLineEnableJudge) {
        for (int i = 0; i < height; i++) {
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