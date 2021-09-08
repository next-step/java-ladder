package nextstep.ladder;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void ladder_size_test() {
        Ladder ladder = new Ladder(5, 3);
        assertThat(ladder.getLadder().size()).isEqualTo(5);
    }

    @Test
    public void move() {
        Ladder ladder = new Ladder(1, 3);
        System.out.println(ladder.move(0));
        System.out.println(ladder.move(1));
        System.out.println(ladder.move(2));
    }
}
