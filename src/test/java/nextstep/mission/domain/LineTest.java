package nextstep.mission.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    @Test
    void constructor() {
        assertThat(new Line(
                Arrays.asList(
                        Point.of(true),
                        Point.of(false),
                        Point.of(true),
                        Point.of(false)
                )
        )).isEqualTo(
                new Line(
                        Arrays.asList(
                                Point.of(true),
                                Point.of(false),
                                Point.of(true),
                                Point.of(false)
                        )
                )
        );
    }

    @Test
    void constructorWithSize() {
        assertThat(new Line(4).checkSize(4)).isTrue();
    }

    @Test
    void constructorThrow() {
        assertThatThrownBy(() -> new Line(
                Arrays.asList(
                        Point.of(true),
                        Point.of(true)
                )
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void move() {
        Line line = new Line(
                Arrays.asList(
                        Point.of(false),
                        Point.of(true),
                        Point.of(false),
                        Point.of(false),
                        Point.of(false),
                        Point.of(true)
                )
        );

        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(1)).isEqualTo(-1);
        assertThat(line.move(2)).isEqualTo(0);
        assertThat(line.move(3)).isEqualTo(0);
        assertThat(line.move(4)).isEqualTo(1);
        assertThat(line.move(5)).isEqualTo(-1);
    }

    @Test
    void nextPosition() {
        Line line = new Line(
                Arrays.asList(
                        Point.of(false),
                        Point.of(true),
                        Point.of(false),
                        Point.of(false),
                        Point.of(false),
                        Point.of(true)
                )
        );

        assertThat(line.nextPosition(0)).isEqualTo(1);
        assertThat(line.nextPosition(1)).isEqualTo(0);
        assertThat(line.nextPosition(2)).isEqualTo(2);
        assertThat(line.nextPosition(3)).isEqualTo(3);
        assertThat(line.nextPosition(4)).isEqualTo(5);
        assertThat(line.nextPosition(5)).isEqualTo(4);
    }
}
