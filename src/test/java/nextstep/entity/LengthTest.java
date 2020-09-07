package nextstep.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;

class LengthTest {

    @Test
    @DisplayName("생성자 유효성 처리 확인")
    void validate() {
        assertThatThrownBy(() -> new Length(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사다리 높이 확인")
    @CsvSource(value = {"1,1", "2,2"})
    void getLength(int length, int expected) {
        then(new Length(length).getLength()).isEqualTo(expected);
    }
}
