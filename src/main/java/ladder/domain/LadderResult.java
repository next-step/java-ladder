package ladder.domain;

import java.util.*;

public class LadderResult {

    private static final String ERR_INVALID_PLAYER_INDEX = "참여자의 인덱스가 정확하지 않습니다.";

    private final Map<Integer, Integer> resultData;

    public LadderResult(LadderData ladderData, List<Line> lines) {

        resultData = new HashMap<>();

        for (int playerIndex = 0; playerIndex < ladderData.getPlayerCount(); playerIndex++) {
            resultData.put(playerIndex, followLadder(playerIndex, lines));
        }
    }

    private int followLadder(int startIndex, List<Line> lines) {

        int currentIndex = startIndex;

        for (Line line : lines) {
            currentIndex = line.move(currentIndex);
        }

        return currentIndex;
    }

    public int searchRewardIndex(int playerIndex) {
        return Optional.ofNullable(resultData.get(playerIndex))
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_PLAYER_INDEX));
    }
}
