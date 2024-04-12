package nextstep.ladder.domain.result;

import nextstep.ladder.domain.result.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ResultTest {

    @DisplayName("게임 결과값은")
    @Nested
    class Describe_constructor {

        @DisplayName("각 사다리 열의 결과값을 갖는다.")
        @Test
        void create() {
            assertThatCode(() -> new Result("꽝"))
                    .doesNotThrowAnyException();
        }

        @DisplayName("null이나 빈 문자열을 갖지 못한다.")
        @ParameterizedTest
        @NullAndEmptySource
        void not_blank(String result) {
            assertThatIllegalArgumentException()
                    .isThrownBy(() -> new Result(result));
        }
    }

}
