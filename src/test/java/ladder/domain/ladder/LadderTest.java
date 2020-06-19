package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderTest {
    private static final int countOfUser = 4;

    @ParameterizedTest(name = "사다리 높이 = {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("사다리 높이를 파라미터로 받아 Ladder 생성")
    void create_ladder(int height) {
        assertThat(Ladder.of(height, countOfUser).getFootStepSize()).isEqualTo(height);
    }

    @ParameterizedTest(name = "사다리 높이 = {0}")
    @ValueSource(ints = 0)
    @DisplayName("사다리 높이는 1이상이 아닌 경우 생성할 수 없다")
    void does_not_create_ladder(int height) {
        assertThatThrownBy(() -> Ladder.of(height, countOfUser))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사다리의 높이는 1이상의 값이어야 합니다.");
    }
}