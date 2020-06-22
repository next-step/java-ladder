package laddergame.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeTest {

    @DisplayName("당첨 결과명 Null 또는 공백이면 IllegalArgumentException throw")
    @ParameterizedTest
    @NullAndEmptySource
    void validateResult(String resultName) {
        assertThatThrownBy(() -> new Prize(resultName, 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("당첨 결과명은 Null 이나 공백일 수 없습니다.");
    }
}