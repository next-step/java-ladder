package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.domain.LadderDrawingSettings;
import nextstep.ladder.domain.LadderGamePrizes;
import nextstep.ladder.domain.LadderGameSettings;
import nextstep.ladder.domain.LadderSize;
import nextstep.ladder.domain.Players;
import nextstep.ladder.exception.WrongLadderGameSettingsException;
import nextstep.ladder.strategy.RandomDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameSettingsTest {


    @Test
    @DisplayName("플레이어 수과 게임보상의 수가 같은 경우, 예외를 던지지 않는다.")
    void checkPlayerAndPrizeCount() {
        Players players = Players.from(new String[]{"kim", "jess"});
        LadderGamePrizes ladderGamePrizes = LadderGamePrizes.from(new String[]{"꽝", "당첨"});
        LadderDrawingSettings drawingSettings = LadderDrawingSettings
            .of(LadderSize.of(players.count(), 2), ladderLabels, new RandomDrawLineStrategy());

        assertThatCode(() -> LadderGameSettings.of(players, ladderGamePrizes, drawingSettings))
            .doesNotThrowAnyException();

    }


    @Test
    @DisplayName("플레이어 수과 게임보상의 수가 다를경우, 예외를 던진다.")
    void invalidPlayerAndPrizeCount() {
        Players players = Players.from(new String[]{"kim", "jess"});
        LadderGamePrizes ladderGamePrizes = LadderGamePrizes.from(new String[]{"꽝", "당첨", "당첨"});
        LadderDrawingSettings drawingSettings = LadderDrawingSettings
            .of(LadderSize.of(players.count(), 2), ladderLabels, new RandomDrawLineStrategy());

        assertThatThrownBy(() -> LadderGameSettings.of(players, ladderGamePrizes, drawingSettings))
            .isInstanceOf(WrongLadderGameSettingsException.class);
    }
}