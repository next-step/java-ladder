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
        assertThatThrownBy(() -> Length.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리 높이는 최소 1 단위 까지 부여할 수 있어요.");
    }

    @ParameterizedTest
    @DisplayName("사다리 높이 확인")
    @CsvSource(value = {"1,1", "2,2"})
    void getLength(int length, int expected) {
        then(Length.of(length).getLength()).isEqualTo(expected);
    }

    @Test
    @DisplayName("팩토리 메소드 검증")
    void of() {
        int length = 1;
        int expected = 1;
        then(Length.of(length)).isEqualTo(Length.of(expected));
    }
}
