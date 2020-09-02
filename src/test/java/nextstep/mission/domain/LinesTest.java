package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    void constructor() {
        assertThat(new Lines(1, 10)).isNotNull();
    }

    @Test
    void getLine() {
        Lines lines = new Lines(1, 1);
        assertThat(lines.getLine(0)).isNotNull();
    }

    @Test
    void getLines() {
        Lines lines = new Lines(1, 1);
        assertThat(lines.getLines()).hasSize(1);
    }

    @Test
    void checkHeight() {
        Lines lines = new Lines(1, 1);
        assertThat(lines.checkHeight(1)).isTrue();
        assertThat(lines.checkHeight(2)).isFalse();
    }

    @Test
    void getResultPosition() {
        Lines lines = new Lines(
                Arrays.asList(
                        new Line(
                                Arrays.asList(
                                        Point.of(false),
                                        Point.of(true),
                                        Point.of(false),
                                        Point.of(false),
                                        Point.of(false),
                                        Point.of(true)
                                )
                        )
                )
        );

        assertThat(lines.getResultPosition(0)).isEqualTo(1);
        assertThat(lines.getResultPosition(1)).isEqualTo(0);
        assertThat(lines.getResultPosition(2)).isEqualTo(2);
        assertThat(lines.getResultPosition(3)).isEqualTo(3);
        assertThat(lines.getResultPosition(4)).isEqualTo(5);
        assertThat(lines.getResultPosition(5)).isEqualTo(4);
    }
}
