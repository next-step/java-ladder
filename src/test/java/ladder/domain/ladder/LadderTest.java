package ladder.domain.ladder;

import ladder.domain.util.RightPointRandom;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    void getSize() {
        Ladder ladder = new Ladder(5, 3, new RightPointRandom());
        Assertions.assertThat(ladder.getLines().size()).isEqualTo(3);
    }

}