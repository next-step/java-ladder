package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GamerTest {

    @Test
    void of() {
        Gamer actual = Gamer.of("test", 1);
        Gamer expected = new Gamer(Name.from("test"), Position.from(1));

        assertThat(actual).isEqualTo(expected);
    }
    @Test
    void climb() {
        Gamer gamer = Gamer.of("test", 1);
        Gamer climbed = gamer.climb(LadderTest.getLadder());

        assertThat(climbed).isEqualTo(gamer);
    }
}