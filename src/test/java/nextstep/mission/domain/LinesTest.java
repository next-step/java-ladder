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
    void getLines() {
        Lines lines = new Lines(1, 1);
        assertThat(lines.getLines()).hasSize(1);
    }

    @Test
    void getResultPosition() {
        Lines lines = new Lines(
                Arrays.asList(
                        new Line(
                                Arrays.asList(
                                        new Point(0, Direction.of(false, true)),
                                        new Point(1, Direction.of(true, false)),
                                        new Point(2, Direction.of(false, false)),
                                        new Point(3, Direction.of(false, false)),
                                        new Point(4, Direction.of(false, true)),
                                        new Point(5, Direction.of(true, false))
                                )
                        )
                )
        );

        assertThat(lines.getResultByPosition(0)).isEqualTo(1);
        assertThat(lines.getResultByPosition(1)).isEqualTo(0);
        assertThat(lines.getResultByPosition(2)).isEqualTo(2);
        assertThat(lines.getResultByPosition(3)).isEqualTo(3);
        assertThat(lines.getResultByPosition(4)).isEqualTo(5);
        assertThat(lines.getResultByPosition(5)).isEqualTo(4);
    }
}
