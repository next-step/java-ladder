package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_PLAYER_COUNT = 2;

    private final List<Boolean> points;

    public Ladder(int playerCount, int maxLadderHeight) {
        validateMinPlayerCount(playerCount);
        this.points = new ArrayList<>();
    }

    private void validateMinPlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(String.format("참가자 수는 최소 %d명 이어야 합니다.", MIN_PLAYER_COUNT));
        }
    }
}
