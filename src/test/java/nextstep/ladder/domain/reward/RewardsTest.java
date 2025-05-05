package nextstep.ladder.domain.reward;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RewardsTest {
    @ParameterizedTest
    @NullAndEmptySource
    public void 공백문자열은_입력될수없다(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Rewards(input);
        });
    }

    @Test
    public void 빈리스트는_입력될수없다() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Rewards(new ArrayList<>());
        });
    }
}
