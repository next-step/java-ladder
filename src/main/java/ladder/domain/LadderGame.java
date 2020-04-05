package ladder.domain;

public class LadderGame {
    private static final int RULE_PLAYER_COUNT = 2;
    private static final int RULE_LADDER_HEIGHT_COUNT = 2;

    private Players players;
    private Ladder ladder;

    public LadderGame(Players players, int ladderHeight) {
        validate(players, ladderHeight);
        this.players = players;
        this.ladder = new Ladder(players, ladderHeight);
    }

    public void validate(Players players, int ladderHeight) {
        if (players.getPlayersCount() < RULE_PLAYER_COUNT) {
            throw new IllegalArgumentException(String.format("플레이어는 %d명 이상이어야 합니다.", RULE_PLAYER_COUNT));
        }

        if (ladderHeight < RULE_LADDER_HEIGHT_COUNT) {
            throw new IllegalArgumentException(String.format("사다리 높이는 %d 이상이어야 합니다.", RULE_LADDER_HEIGHT_COUNT));
        }
    }
}
