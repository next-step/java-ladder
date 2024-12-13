package ladder.domain.engine;

import ladder.domain.impl.RandomLineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineGeneratorTest {

    @DisplayName("플레이어 수보다 1개 작은 갯수의 가로선 포인트를 생성할 수 있다.")
    @Test
    void generateTest() {
        int numberOfPlayers = 4;
        LineGenerator lineGenerator = new RandomLineGenerator();
        List<Boolean> points = lineGenerator.generate(numberOfPlayers);

        assertThat(points.size()).isEqualTo(numberOfPlayers - 1);
    }
}