package ladder.domain;

import ladder.domain.exception.LessThanMinimumNumberException;
import ladder.domain.exception.NonNumericStringException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static ladder.domain.LadderHeight.MINIMUM;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderHeightTest {

    @DisplayName("생성할 때")
    @Nested
    class Create {

        @DisplayName("숫자인 문자열로 높이를 정할 수 있다.")
        @Test
        void create_string_number() {
            LadderHeight expected = new LadderHeight(7);

            LadderHeight actual = new LadderHeight("7");

            assertThat(actual).isEqualTo(expected);
        }

        @DisplayName("1보다 작은 수가 입려되면 예외가 발생한다.")
        @Test
        void validate_less_then_zero() {
            assertThatThrownBy(() -> new LadderHeight(-1))
                    .isExactlyInstanceOf(LessThanMinimumNumberException.class)
                    .hasMessage("최소 숫자 보다 작은 숫자는 입력될 수 없습니다. 최소 숫자 : " + MINIMUM);
        }

        @DisplayName("숫자가 아닌 문자열이 입력되면 예외가 발생한다.")
        @Test
        void validate_number() {
            assertThatThrownBy(() -> new LadderHeight("10 "))
                    .isExactlyInstanceOf(NonNumericStringException.class)
                    .hasMessage("숫자가 아닌 문자열이 입력되었습니다.");
        }
    }
}
