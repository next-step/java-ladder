package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderInputTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "go", "iam", "test", "given", "꽝", "4000"})
    @DisplayName("입력값 생성 테스트")
    void ladderInputTest(String input) {
        LadderInput ladderInput = new LadderInput(input);

        assertThat(ladderInput.getLadderInput())
                .isEqualTo(input);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력값이 없거나 null일 경우 예외 처리")
    void nullOrEmptyTest(String input) {
        assertThatThrownBy(() -> new LadderInput(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("입력값이 없습니다.");
    }

    @Test
    @DisplayName("입력값이 5자 초과일 경우 에러 반환 테스트")
    void moreFiveLengthErrorTest() {
        assertThatThrownBy(() -> new LadderInput("python"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
