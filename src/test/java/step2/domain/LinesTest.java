package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LinesTest {

    private final List<Line> lineList = Arrays.asList(
            new Line(Arrays.asList(false, true, false, true)),
            new Line(Arrays.asList(false, false, true, false)),
            new Line(Arrays.asList(false, true, false, false)),
            new Line(Arrays.asList(false, false, true, false)),
            new Line(Arrays.asList(false, true, false, true)));
    private final Lines lines = new Lines(lineList);

    @Test
    void moveTest() {
        final int actual = lines.move(0);
        final int expect = 0;
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void moveTest2() {
        final int actual = lines.move(1);
        final int expect = 3;
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void moveTest3() {
        final int actual = lines.move(2);
        final int expect = 2;
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    void moveTest4() {
        final int actual = lines.move(3);
        final int expect = 1;
        assertThat(actual).isEqualTo(expect);
    }
}