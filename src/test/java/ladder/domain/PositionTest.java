package ladder.domain;

import ladder.domain.exception.LessThanZeroNumberException;
import ladder.domain.exception.NonNumericStringException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositionTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("기본 위치값은 0이다.")
        @Test
        void default_0() {
            assertThat(new Position()).isEqualTo(new Position(0));
        }

        @DisplayName("String 타입으로 위치 값을 입력 받을 수 있다.")
        @Test
        void string() {
            assertThat(new Position("1")).isEqualTo(new Position(1));
        }

        @DisplayName("0보다 작은 수가 입려되면 예외가 발생한다.")
        @Test
        void validate_less_then_zero() {
            assertThatThrownBy(() -> new Position(-1))
                    .isExactlyInstanceOf(LessThanZeroNumberException.class)
                    .hasMessage("0보다 작은 숫자는 입력될 수 없습니다.");
        }

        @DisplayName("숫자가 아닌 문자열이 입력되면 예외가 발생한다.")
        @Test
        void validate_number() {
            assertThatThrownBy(() -> new Position("10 "))
                    .isExactlyInstanceOf(NonNumericStringException.class)
                    .hasMessage("숫자가 아닌 문자열이 입력되었습니다.");
        }
    }
}
