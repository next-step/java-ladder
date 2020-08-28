package camp.nextstep.edu.rebellion.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LadderGameModeTest {
    @DisplayName("입력 값에 대한 mode 를 잘 가져오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1:ORIGIN",
            "2:CUSTOM"
    }, delimiter = ':')
    public void ofTest(int input, LadderGameMode mode) {
        // when & then
        assertThat(LadderGameMode.of(input) == mode).isTrue();
    }

    @DisplayName("존재하지 않은 mode 일 경우 예외 발생")
    @Test
    public void ofThrownTest() {
        // given
        int input = 0;

        // when & then
        assertThatThrownBy(
                () -> LadderGameMode.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("지원하지 않는 모드 입니다");
    }
}
