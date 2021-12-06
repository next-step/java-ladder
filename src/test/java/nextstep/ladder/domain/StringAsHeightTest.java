package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAsHeightTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    @DisplayName("생성 성공")
    void intValue(String number) {
        assertThat(new StringAsHeight(number).height()).isEqualTo(new Height(Integer.parseInt(number)));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a", "`", "."})
    @DisplayName("숫자 이외의 값 예외처리")
    void numberFormatException(String number) {
        assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> new StringAsHeight(number).height());
    }

}
