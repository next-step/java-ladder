package net.chandol.ladder.v2.domain;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    public void 사다리만들기() {
        List<String> players = asList("aaa", "bbb");
        LinesGenerator linesGenerator = new ManualLinesGenerator(
                Line.of(true, false),
                Line.of(false, false)
        );

        Ladder ladder = new Ladder(players, 1, linesGenerator);

        assertThat(ladder.hasPoint(0, 0)).isTrue();
        assertThat(ladder.hasPoint(1, 0)).isFalse();
    }

}