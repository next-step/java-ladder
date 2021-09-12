package nextstep.ladder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.domain.LadderGamePrizes;
import nextstep.ladder.domain.LadderGameSettings;
import nextstep.ladder.domain.LadderHeight;
import nextstep.ladder.domain.Players;
import nextstep.ladder.exception.WrongLadderGameSettingsException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameSettingsTest {


    @Test
    @DisplayName("플레이어 수과 게임보상의 수가 같은 경우, 예외를 던지지 않는다.")
    void checkPlayerAndPrizeCount() {
        final Players players = Players.from(new String[]{"a", "b"});
        final LadderHeight ladderHeight = LadderHeight.of(2);
        final LadderGamePrizes ladderGamePrizes = LadderGamePrizes.from(new String[]{"1", "2"});

        assertThatCode(() -> LadderGameSettings.of(players, ladderHeight, ladderGamePrizes))
            .doesNotThrowAnyException();

    }


    @Test
    @DisplayName("플레이어 수과 게임보상의 수가 다를경우, 예외를 던진다.")
    void invalidPlayerAndPrizeCount() {
        final Players players = Players.from(new String[]{"a", "b"});
        final LadderHeight ladderHeight = LadderHeight.of(2);
        final LadderGamePrizes ladderGamePrizes = LadderGamePrizes
            .from(new String[]{"1", "2", "extraPrize"});

        assertThatThrownBy(() -> LadderGameSettings.of(players, ladderHeight, ladderGamePrizes))
            .isInstanceOf(WrongLadderGameSettingsException.class);
    }
}