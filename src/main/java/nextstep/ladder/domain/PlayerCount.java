package nextstep.ladder.domain;

public class PlayerCount {
    private static final int MIN_PLAYER_COUNT = 2;
    private final int count;

    public PlayerCount(final int count) {
        if(count < MIN_PLAYER_COUNT) {
            throw new IllegalArgumentException("플레이어가 부족합니다. 최소 : " + MIN_PLAYER_COUNT);
        }
        this.count = count;
    }

    public int count() {
        return count;
    }
}
