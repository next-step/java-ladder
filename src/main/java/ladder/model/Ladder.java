package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int MIN_PLAYER_COUNT = 2;
    private static final int MIN_LADDER_HEIGHT = 1;

    private final List<Boolean> points;

    Ladder(int playerCount, int ladderHeight) {
        validateMinPlayerCount(playerCount);
        validateMinLadderHeight(ladderHeight);
        this.points = new ArrayList<>();
    }

    private void validateMinPlayerCount(int playerCount) {
        if (playerCount < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException(String.format("참가자 수는 최소 %d명 이어야 합니다.", MIN_PLAYER_COUNT));
        }
    }

    private void validateMinLadderHeight(int ladderHeight) {
        if (ladderHeight < MIN_LADDER_HEIGHT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 %d 이어야 합니다.", MIN_LADDER_HEIGHT));
        }
    }
}
