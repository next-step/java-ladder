package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static nextstep.ladder.domain.IndexedName.wrap;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("|-----|     |" +
             "|     |-----| 의 경우")
class LadderTest {

    private Ladder line;

    @BeforeEach
    void setUp() {
        line = Ladder.of(Stream.of(Spoke.of(true, false), Spoke.of(false, true)),
                         wrap(asList("boom", "5000", "boom")));
    }

    @DisplayName("특정 플레이어의 이동결과를 리턴한다")
    @Test
    void moveForName() {
        assertAll(
                () -> assertThat(line.moveFor(new IndexedName(0, "red"))).isEqualTo("boom"),
                () -> assertThat(line.moveFor(new IndexedName(1, "blue"))).isEqualTo("boom"),
                () -> assertThat(line.moveFor(new IndexedName(2, "green"))).isEqualTo("5000")
        );
    }

    @DisplayName("모든 플레이어의 이동결과를 리턴한다")
    @Test
    void moveForAll() {
        assertThat(line.moveForAll(wrap(asList("red", "blue", "green"))))
                .containsOnly(
                        entry("red", "boom"),
                        entry("blue", "boom"),
                        entry("green", "5000")
                );
    }
}
