package ladder;

import ladder.domain.GamePrize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GamePrizeTest {
    private static final String SPLIT_DELIMITER = ",";

    @ParameterizedTest
    @ValueSource(strings = {"꽝,1000,3000", "당첨,꽝,꽝"})
    void 참가자_생성(String input) {
        GamePrize gamePrize = GamePrize.generateGamePrize(input.split(SPLIT_DELIMITER, -1));
        assertThat(gamePrize).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", ",,", "꽝, 1000, 3000", "100000,꽝,꽝"})
    void 적절하지_않은_참가자_생성(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> GamePrize.generateGamePrize(input.split(SPLIT_DELIMITER, -1)));
    }
}
