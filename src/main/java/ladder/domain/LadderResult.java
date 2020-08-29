package ladder.domain;

import java.util.*;

public class LadderResult {

    private static final String ERR_INVALID_PLAYER_INDEX = "참여자의 인덱스가 정확하지 않습니다.";

    private final Map<Integer, Integer> result;

    public LadderResult(LadderData ladderData, List<Line> lines) {

        result = new HashMap<>();

        for (int playerIndex = 0; playerIndex < ladderData.getPlayerCount(); playerIndex++) {
            result.put(playerIndex, followLadder(playerIndex, lines));
        }
    }

    private int followLadder(int startIndex, List<Line> lines) {

        int currentIndex = startIndex;

        for (Line line : lines) {
            currentIndex = nextIndex(line, currentIndex);
        }

        return currentIndex;
    }

    private int nextIndex(Line line, int currentIndex) {

        if (line.hasLeftBar(currentIndex)) {
            return currentIndex - 1;
        }

        if (line.hasRightBar(currentIndex)) {
            return currentIndex + 1;
        }

        return currentIndex;
    }

    public int searchRewardIndex(int playerIndex) {
        return Optional.ofNullable(result.get(playerIndex))
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_PLAYER_INDEX));
    }
}
