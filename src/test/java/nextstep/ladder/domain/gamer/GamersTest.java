package nextstep.ladder.domain.gamer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GamersTest {

    @Test
    void of() {
        Gamers gamers = Gamers.of(Arrays.asList("pobi", "unit1", "test"));
        assertThat(gamers)
                .isEqualTo(Gamers.of(Arrays.asList("pobi", "unit1", "test")));
    }

    @Test
    void ofException() {
        assertThatThrownBy(() -> Gamers.of(Collections.singletonList("tester")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void size() {
        Gamers gamers = Gamers.of(Arrays.asList("pobi", "unit1", "test"));
        assertThat(gamers.size())
                .isEqualTo(3);
    }

    @Test
    void getNumber() {
        Gamers gamers = Gamers.of(Arrays.asList("pobi", "unit1", "test"));
        assertThat(gamers.getLadderNumber("test"))
                .isEqualTo(2);
    }

    @Test
    void getGamers() {
        Gamers gamers = Gamers.of(Arrays.asList("pobi", "unit1", "test"));
        assertThat(gamers.getGamers())
                .containsExactly("pobi", "unit1", "test");
    }

}