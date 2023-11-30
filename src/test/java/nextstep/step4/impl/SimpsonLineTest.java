package nextstep.step4.impl;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpsonLineTest {

    @Test
    void moveRightTest() {
        final List<Point> list = Arrays.asList(Point.first(true), Point.first(true).last());
        final SimpsonLine simpsonLine = new SimpsonLine(list);

        assertThat(simpsonLine.move(0)).isEqualTo(1);
    }

    @Test
    void moveLeftTest() {
        final List<Point> list = Arrays.asList(Point.first(false), Point.first(true).last());
        final SimpsonLine simpsonLine = new SimpsonLine(list);

        assertThat(simpsonLine.move(1)).isEqualTo(0);
    }
}