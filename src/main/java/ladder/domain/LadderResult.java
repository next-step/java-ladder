package ladder.domain;

import java.util.*;

public class LadderResult {

    private static final String ERR_INVALID_PLAYER_INDEX = "참여자의 인덱스가 정확하지 않습니다.";

    private final Map<Integer, Integer> resultData;

    public LadderResult() {
        resultData = new HashMap<>();
    }

    public void put(int playerIndex, int rewardIndex) {
        resultData.put(playerIndex, rewardIndex);
    }

    public int searchRewardIndex(int playerIndex) {
        return Optional.ofNullable(resultData.get(playerIndex))
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_PLAYER_INDEX));
    }
}
