package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    @Test
    void height() {
         Ladder ladder = new Ladder();

         assertThat(ladder.height()).isEqualTo(0);
    }
}
