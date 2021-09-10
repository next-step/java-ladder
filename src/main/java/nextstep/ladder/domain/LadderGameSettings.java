package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.WrongLadderGameSettingsException;

public class LadderGameSettings {

    private final Players players;
    private final LadderHeight ladderHeight;
    private final LadderGamePrizes ladderGamePrizes;

    public LadderGameSettings(Players players, LadderHeight height, LadderGamePrizes prizes) {
        validatePlayerAndPrizeCount(players, prizes);

        this.players = Objects.requireNonNull(players);
        this.ladderHeight = Objects.requireNonNull(height);
        this.ladderGamePrizes = Objects.requireNonNull(prizes);
    }

    public static LadderGameSettings of(Players players, LadderHeight height, LadderGamePrizes prizes) {
        return new LadderGameSettings(players, height, prizes);
    }

    private void validatePlayerAndPrizeCount(Players players, LadderGamePrizes ladderGamePrizes) {

        final int playerCount = players.count();
        final int prizeCount = ladderGamePrizes.count();
        if (playerCount != prizeCount) {
            throw new WrongLadderGameSettingsException(String
                .format("플레이어 수와 게임결과보상의 수가 일치하지 않습니다. [플레이어 수: %d] [게임보상수 %d]", playerCount, prizeCount));
        }
    }


    public Players getPlayers() {
        return players;
    }

    public LadderGamePrizes getLadderGamePrizes() {
        return ladderGamePrizes;
    }

    public LadderHeight getLadderHeight() {
        return ladderHeight;
    }
}
