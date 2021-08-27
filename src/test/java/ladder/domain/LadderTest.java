package ladder.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    private static Ladder ladder;

    @BeforeAll
    static void setUp() {
        List<Line> lines = Arrays.asList(
                Line.of(Arrays.asList(true, false, false, true)),
                Line.of(Arrays.asList(false, true, false, false)),
                Line.of(Arrays.asList(true, false, true, false)),
                Line.of(Arrays.asList(true, false, false, true))
        );
        ladder = new Ladder(lines);
    }

    @DisplayName("사다리 높이 확인")
    @Test
    void create() {
        assertThat(ladder.getLines().size()).isEqualTo(4);
    }

}