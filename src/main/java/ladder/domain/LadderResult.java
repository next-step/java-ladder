package ladder.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class LadderResult {

    private static final String ERR_INVALID_PLAYER_INDEX = "참여자의 인덱스가 정확하지 않습니다.";

    private final Map<Integer, Integer> resultMap;

    public LadderResult(Map<Integer, Integer> resultMap) {
        this.resultMap = Collections.unmodifiableMap(resultMap);
    }

    public int searchRewardIndex(int playerIndex) {
        return Optional.ofNullable(resultMap.get(playerIndex))
                .orElseThrow(() -> new IllegalArgumentException(ERR_INVALID_PLAYER_INDEX));
    }

    public Integer get(int index) {
        return resultMap.get(index);
    }
}
