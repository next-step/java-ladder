package nextstep.ladder.domain.player;

import nextstep.ladder.domain.ladder.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CountTest {

    @DisplayName("개수는")
    @Nested
    class Describe_constructor {

        @DisplayName("0 이상의 개수를 가질 수 있다.")
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2})
        void can_have_positive_count(int count) {
            assertThatCode(() -> new Count(count))
                    .doesNotThrowAnyException();
        }

        @DisplayName("음수를 가질 수 없다.")
        @Test
        void cannot_have_negative_count() {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Count(-1));
        }
    }

}
