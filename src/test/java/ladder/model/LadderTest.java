package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void 사다리_생성() {
        Random fixedRandom = new Random(0);

        Ladder ladder = new Ladder(fixedRandom, 5, 3);

        assertThat(ladder.getHeight()).isEqualTo(3);
        List<LadderLine> lines = ladder.getLines();
        lines.forEach(line -> {
            assertThat(line.size()).isEqualTo(4);
        });
    }

    @Test
    void 사다리_타기() {
        Random random = new AlwaysTrueRandom();
        Ladder ladder = new Ladder(random, 3, 5);

        assertThat(ladder.run(0)).isEqualTo(1);
        assertThat(ladder.run(1)).isEqualTo(0);
        assertThat(ladder.run(2)).isEqualTo(2);
    }

    static class AlwaysTrueRandom extends Random {
        @Override
        public boolean nextBoolean() {
            return true;
        }
    }

}
