package nextstep.ladder.domain.reward;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void 보상값은_null이거나_빈공백일경우_에러(String value) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Reward(value)
        );
    }
}
