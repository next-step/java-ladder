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

    @DisplayName("add는 현재 열 번호에 특정한 값이 더해진 열 번호를 반환한다. 단, 최소값은 0으로 유지된다.")
    @ParameterizedTest
    @CsvSource(value = {"0,-1,0", "0,1,1", "0,0,0"})
    void move(int current, int move, int expected) {
        assertThat(new ColumnIndex(current).move(move))
                .isEqualTo(new ColumnIndex(expected));
    }
}
