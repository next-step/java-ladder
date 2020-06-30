package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder {
    private static final int MIN_START_POSITION_COUNT = 2;

    private final List<HorizonLine> horizonLines = new ArrayList<>();

    public Ladder(LadderHeight height, Participants participants, LadderPrizes ladderPrizes) {
       this(height, participants, ladderPrizes, () -> new Random().nextBoolean());
    }

    public Ladder(LadderHeight height,
                  Participants participants,
                  LadderPrizes ladderPrizes,
                  ShortLineEnableJudge shortLineEnableJudge) {
        validateMinPositionCount(participants.size());
        validateSameCount(participants, ladderPrizes);
        createHorizonLine(height, participants.size(), shortLineEnableJudge);
    }

    private void validateMinPositionCount(int startPositionCount) {
        if (startPositionCount < MIN_START_POSITION_COUNT) {
            throw new IllegalArgumentException("사다리를 시작하기 위해서는 2명 이상의 사용자가 필요합니다.");
        }
    }

    private void validateSameCount(Participants participants, LadderPrizes ladderPrizes) {
        if (participants.size() != ladderPrizes.size()) {
            throw new IllegalArgumentException("사다리 게임에 참여자의 수와 사다리 결과 수가 다릅니다.");
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

    protected int play(int startPositionIndex) {
        for (int i = 0; i < getHeight(); i++) {
            startPositionIndex = moveShortLine(i, startPositionIndex);
        }
        return startPositionIndex;
    }

    protected List<Integer> playAll() {
        List<Integer> resultIndex = new ArrayList<>();
        for (int i = 0 ; i < getStartPositionCount() ; i++) {
            resultIndex.add(play(i));
        }
        return resultIndex;
    }

    private int getStartPositionCount() {
        HorizonLine firstHorizonLine = horizonLines.get(0);
        return firstHorizonLine.getShortLineCount() + 1;
    }

    private int moveShortLine(int height, int currentPosition) {
        int nextVerticalLinePosition = currentPosition;
        if (isEnabledShortLineOfLeft(height, nextVerticalLinePosition)) {
            return --nextVerticalLinePosition;
        }
        if (isEnabledShortLineOfRight(height, nextVerticalLinePosition)) {
            return ++nextVerticalLinePosition;
        }
        return currentPosition;
    }
}
