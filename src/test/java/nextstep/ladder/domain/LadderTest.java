package nextstep.ladder.domain;

import nextstep.ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {

    @Test
    void getLadder() {
        Ladder ladder = new Ladder(4, 5);
        assertThat(ladder.getLadder().size()).isEqualTo(5);
    }

    @Test
    void play() {
        Ladder ladder = new Ladder(4, 5);
        Location location;
        location = ladder.play();
        for (int i = 0; i < 4; i++) {
            System.out.println(location.getter(i));
        }
    }
}
