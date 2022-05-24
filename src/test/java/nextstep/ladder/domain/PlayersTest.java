package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {
    private List<String> names;

    @BeforeEach
    void setUp() {
        names = List.of("jack", "pobi");
    }

    @Test
    void countOfLines() {
        assertThat(Players.of(names).countOfLines()).isEqualTo(1);
    }

    @Test
    void of() {
        assertThat(Players.of(names).players()).isEqualTo(List.of(
                new Player("jack", Coordinate.of(0,0)),
                new Player("pobi", Coordinate.of(1,0))));
    }

    @Test
    void sameLength_fail() {
        assertThat(Players.of(List.of("a", "b", "c")).sameLength((List.of("X", "3000")))).isFalse();
    }
}
