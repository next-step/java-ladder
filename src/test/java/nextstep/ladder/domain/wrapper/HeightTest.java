package nextstep.ladder.domain.wrapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static nextstep.ladder.exception.ExceptionMessage.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @DisplayName("인자로 높이 값을 받아 생성한다.")
    @Test
    void createAxisX() {
        assertThat(new Height(1)).isEqualTo(new Height(1));
    }

    @DisplayName("높이를 생성할 때 양의 정수가 아니면 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validateHeight(int height) {
        assertThatThrownBy(() -> new Height(height)).isInstanceOf(IllegalArgumentException.class)
            .hasMessage(NOT_POSITIVE.message());
    }
}