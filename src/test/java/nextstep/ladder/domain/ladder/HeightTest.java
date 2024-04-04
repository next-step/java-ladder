package nextstep.ladder.domain.ladder;

import nextstep.ladder.domain.ladder.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class HeightTest {

    @DisplayName("높이는")
    @Nested
    class Describe_constructor {

        @DisplayName("1 이상의 높이를 가질 수 있다.")
        @ParameterizedTest
        @ValueSource(ints = {1, 2})
        void can_have_positive_height(int height) {
            assertThatCode(() -> new Height(height))
                    .doesNotThrowAnyException();
        }

        @DisplayName("음수나 0을 가질 수 없다.")
        @ParameterizedTest
        @ValueSource(ints = {-1, 0})
        void cannot_have_negative_height(int height) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Height(height));
        }
    }

}
