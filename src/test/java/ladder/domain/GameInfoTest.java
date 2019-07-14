package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameInfoTest {
    @Test
    void 플레이어_수와_결과의_수가_같지_않으면_예외가_발생한다() {
        String inputPlayers = "1,2,3,4";
        String inputResults = "일,이,삼,사,오";
        Prizes prizes = Prizes.from(inputResults);
        Players players = Players.of(inputPlayers);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    GameInfo.of(players, prizes);
                }).withMessage(GameInfo.ALERT_INVALID_NUMBER_OF_PRIZES);
    }
}
