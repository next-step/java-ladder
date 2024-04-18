package ladder;

import ladder.domain.Prize;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PrizeTest {
    @ParameterizedTest
    @ValueSource(strings = {"꽝", "1000", "10000"})
    void 결과값_생성(String input) {
        Prize prize = new Prize(input);
        assertThat(prize).isEqualTo(new Prize(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", " 꽝", "10 00"})
    void 결과값_생성_빈값_포함(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Prize(input))
                .withMessage("결과값은 공백을 포함할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"100000", ""})
    void 결과값_생성_길이_초과(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Prize(input))
                .withMessage("결과값은 1자 이상 5자 이하여야 합니다.");
    }
}
