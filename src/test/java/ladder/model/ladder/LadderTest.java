package ladder.model.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("사다리 line size가 height와 동일한 것 테스트")
    void ladderLinesSizeTest(int height) {
        Ladder ladder = Ladder.create(height, 5);
        assertThat(ladder.lines().size()).isEqualTo(height);
    }
}
