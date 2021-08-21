package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {


    @Test
    @DisplayName("Ladder 생성 후 사이즈 체크")
    void generateLadder_sizeCheck() {
        DirectionStrategy directionStrategy = new RandomDirectionStrategy();
        Ladder ladder = new Ladder(directionStrategy, 4, 5);

        List<Line> lines = ladder.getLines();
        int actual = lines.size();
        assertThat(actual).isEqualTo(4);
    }
}