package nextstep.step4.impl;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class SimpsonLadderTest {

    @Test
    void playTest() {
        final SimpsonLine simpsonLine1 = new SimpsonLine(Arrays.asList(Point.first(true), Point.first(true).last()));
        final SimpsonLine simpsonLine2 = new SimpsonLine(Arrays.asList(Point.first(false), Point.first(false).next(false)));
        final SimpsonLadder simpsonLadder = new SimpsonLadder(Arrays.asList(simpsonLine1, simpsonLine2), 2);

        assertThat(simpsonLadder.play().get(0)).isEqualTo(1);
    }
}