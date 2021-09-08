package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.exception.WrongLadderGamePrizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class LadderGamePrizeTest {

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "당첨", "1000"})
    @DisplayName("적합한 이름을 지정해 게임보상을 지정할수 있다.")
    void validPrize(String prizeName) {
        assertThatCode(() -> new LadderGamePrize(prizeName))
            .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("보상이름이 null이거나 공백일 경우, 예외를 던진다.")
    void inValidPrize(String prizeName) {
        assertThatThrownBy(() -> new LadderGamePrize(prizeName))
            .isInstanceOf(WrongLadderGamePrizeException.class);
    }


}