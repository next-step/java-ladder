package ladder;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    void 다리_생성 () {
        Random fixedRandom = new FixedRandom(new boolean[]{
                true, true, false, true, false, false
        });

        LadderLine line = LadderLine.genRandomLadderLine(6, fixedRandom);

        assertThat(line.crosses()).isEqualTo(List.of(true, false, true, false, false));
    }

    @Test
    public void 붙은_다리_안생김() {
        Random fixedRandom = new FixedRandom(new boolean[]{
                true, true, true, true, true, true
        });

        LadderLine line = LadderLine.genRandomLadderLine(7, fixedRandom);
        List<Boolean> crosses = line.crosses();

        for (int i = 1; i < crosses.size(); i++) {
            assertThat(crosses.get(i - 1) && crosses.get(i)).isFalse();
        }

        assertThat(line.crosses()).isEqualTo(List.of(true, false, true, false, true, false));
    }

    static class FixedRandom extends Random {
        private final boolean[] values;
        private int index = 0;

        FixedRandom(boolean[] values) {
            this.values = values;
        }

        @Override
        public boolean nextBoolean() {
            return values[index++ % values.length];
        }
    }
}