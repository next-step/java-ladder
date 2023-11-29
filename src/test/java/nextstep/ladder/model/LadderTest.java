package nextstep.ladder.model;

import java.util.Random;
import org.junit.jupiter.api.Test;

class LadderTest {

    static class AlwaysReturnTrue extends Random {

        @Override
        public boolean nextBoolean() {
            return true;
        }
    }

    @Test
    void ladder() {
        Ladder ladder = new Ladder(new LadderHeight(5), new PersonCount(4), new AlwaysReturnTrue());
    }

}