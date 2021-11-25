package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PositiveTest {

    @DisplayName("양수가 아니라면 예외를 던진다.")
    @ParameterizedTest(name = "[{index}] value: {0}")
    @ValueSource(ints = {-1, 0})
    void create_notPositive_thrownException(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Positive(value))
                .withMessage(Positive.NOT_POSITIVE_ERROR_MESSAGE);
    }

    @DisplayName("정상 생성")
    @ParameterizedTest(name = "[{index}] value: {0}")
    @ValueSource(ints = {1, 1000})
    void create(int value) {
        assertThat(new Positive(value)).isEqualTo(new Positive(value));
    }

}
