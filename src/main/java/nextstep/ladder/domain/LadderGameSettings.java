package nextstep.ladder.domain;

import java.util.Objects;
import nextstep.ladder.exception.WrongLadderGameSettingsException;

public class LadderGameSettings {

    private final Players players;
    private final LadderGamePrizes ladderGamePrizes;
    private final LadderDrawingSettings drawingSettings;

    public LadderGameSettings(Players players, LadderGamePrizes ladderGamePrizes,
        LadderDrawingSettings drawingSettings) {
        validatePlayerAndPrizeCount(players, ladderGamePrizes);

        this.players = Objects.requireNonNull(players);
        this.ladderGamePrizes = Objects.requireNonNull(ladderGamePrizes);
        this.drawingSettings = Objects.requireNonNull(drawingSettings);
    }

    public static LadderGameSettings of(Players players, LadderGamePrizes ladderGamePrizes,
        LadderDrawingSettings drawingSettings) {
        return new LadderGameSettings(players, ladderGamePrizes, drawingSettings);
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

    public LadderDrawingSettings getDrawingSettings() {
        return drawingSettings;
    }
}
