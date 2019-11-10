package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void height() {
         int expectHeight = 5;
         Ladder ladder = new Ladder(expectHeight);

         assertThat(ladder.height()).isEqualTo(expectHeight);
    }
}
