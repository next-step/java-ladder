package ladder.domain;


import ladder.dto.Gamer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 해당게이머가참여함() {
        List<Gamer> gamers = Arrays.asList(new Gamer("aaa"), new Gamer("bbb"));
        Ladder ladder = new Ladder(gamers);
        assertThat(ladder.containGamer("aaa")).isEqualByComparingTo(new Gamer("aaa"));

    }

    @Test(expected = IllegalArgumentException.class)
    public void 해당게이머가참여안함() {
        List<Gamer> gamers = Arrays.asList(new Gamer("aaa"), new Gamer("bbb"));
        Ladder ladder = new Ladder(gamers);
        ladder.containGamer("ccc");
    }
}