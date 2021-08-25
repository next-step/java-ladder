package ladder.domain.ladder;

import ladder.exception.LadderMinimumHeightException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Ladder TEST")
class LadderTest {

    DirectionStrategy directionStrategy;

    @BeforeEach
    void setUp() {
        directionStrategy = () -> true;
    }

    @Test
    @DisplayName("Ladder 생성 후 사이즈 체크")
    void generateLadder_sizeCheck() {
        Ladder ladder = new Ladder(directionStrategy, 4, 5);

        List<Line> lines = ladder.getLines();
        int actual = lines.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("사다리 높이가 낮을 때 Exception 발생")
    void ladderMinimumHeightException() {
        assertThatThrownBy(() -> new Ladder(directionStrategy, Ladder.MIN_HEIGHT - 1, 5))
                .isInstanceOf(LadderMinimumHeightException.class);
    }

}