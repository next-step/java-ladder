package nextstep.ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("|-----|     |" +
             "|     |-----| 의 경우")
class LadderTest {

    private Ladder line;

    @BeforeEach
    void setUp() {
        line = Ladder.of(Stream.of(Spoke.of(true, false), Spoke.of(false, true)),
                                Arrays.asList("red", "blue", "green"),
                                Arrays.asList("boom", "5000", "boom"));
    }

    @DisplayName("특정 플레이어의 이동결과를 리턴한다")
    @Test
    void moveForName() {
        assertAll(
                () -> assertThat(line.moveFor("red")).isEqualTo("boom"),
                () -> assertThat(line.moveFor("blue")).isEqualTo("boom"),
                () -> assertThat(line.moveFor("green")).isEqualTo("5000")
        );
    }

    @DisplayName("모든 플레이어의 이동결과를 리턴한다")
    @Test
    void moveForAll() {
        assertThat(line.moveForAll())
                .containsOnly(
                        entry("red", "boom"),
                        entry("blue", "boom"),
                        entry("green", "5000")
                );
    }
}
