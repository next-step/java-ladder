package ladder.domain;

public class GameInfo {
    static final String ALERT_INVALID_NUMBER_OF_PRIZES = "상품의 수는 참여자 수와 같아야 합니다.";

    private final Players players;
    private final Prizes prizes;

    private GameInfo(Players players, Prizes prizes) {
        validationPrizes(players, prizes);
        this.players = players;
        this.prizes = prizes;
    }

    public static GameInfo of(Players players, Prizes prizes) {
        return new GameInfo(players, prizes);
    }

    private void validationPrizes(Players players, Prizes prizes) {
        if (players.numberOfPlayers() != prizes.numberOfPrizes()) {
            throw new IllegalArgumentException(ALERT_INVALID_NUMBER_OF_PRIZES);
        }
    }

    Player findPlayerByIndex(int index) {
        return players.findPlayerByIndex(index);
    }

    Prize findPrizeByPosition(Position finalPosition) {
        return prizes.findPrizeByPosition(finalPosition);
    }

    int numberOfPlayers() {
        return players.numberOfPlayers();
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }
}
