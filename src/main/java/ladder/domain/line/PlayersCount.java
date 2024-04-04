package ladder.domain.line;

public class PlayersCount {

    static final int MINIMUM_PLAYERS_COUNT = 2;

    private final int value;

    public PlayersCount(final int value) {
        validatePlayersCountIsNotLessThanMinimum(value);

        this.value = value;
    }

    int value() {
        return this.value;
    }

    private void validatePlayersCountIsNotLessThanMinimum(final int playersCount) {
        if (playersCount < MINIMUM_PLAYERS_COUNT) {
            throw new IllegalArgumentException("플레이어 수는 최소 인원 이상이어야 합니다. 플레이어 수: " + playersCount);
        }
    }
}
