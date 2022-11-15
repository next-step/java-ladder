package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @DisplayName("사다리 플레이어 수와 높이를 입력 받는다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 18, 23, 32})
    public void spec01(final int height) {
        final Ladder ladder = new Ladder(new PlayerCount(4), new Height(height), () -> true);
        assertThat(ladder.lines()).hasSize(height);
    }
}
