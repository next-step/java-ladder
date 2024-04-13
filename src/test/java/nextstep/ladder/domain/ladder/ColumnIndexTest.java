package nextstep.ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ColumnIndexTest {

    @DisplayName("열 번호는")
    @Nested
    class Describe_constructor {

        @DisplayName("0이상의 값을 가진다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        void create(int idx) {
            assertThatCode(() -> new ColumnIndex(idx))
                    .doesNotThrowAnyException();
        }

        @DisplayName("음수를 가질 수 없다.")
        @Test
        void cannot_be_negative() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new ColumnIndex(-1));
        }
    }

    @DisplayName("isFirst는 0번째 열인 경우 true를 반환한다.")
    @Test
    void isFirst() {
        assertThat(new ColumnIndex(0).isFirst()).isTrue();
    }

    @DisplayName("next는 다음 index를 반환한다.")
    @Test
    void next() {
        assertThat(new ColumnIndex(1).next())
                .isEqualTo(new ColumnIndex(2));
    }

    @DisplayName("before는 이전 index를 반환한다. 단, 첫번째인 경우 첫번쨀르 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "0,0"})
    void before(int current, int expected) {
        assertThat(new ColumnIndex(current).before())
                .isEqualTo(new ColumnIndex(expected));
    }
}
