package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void ladder_size_test() {
       Ladder ladder = new Ladder(5,3);
       assertThat(ladder.getLadder().size()).isEqualTo(5);
    }
}
