package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    private Line line;

    @BeforeEach
    void setUp() {
        this.line = new Line(Arrays.asList(
                Point.of(true),
                Point.of(false),
                Point.of(true),
                Point.of(false),
                Point.of(false)
        ));
    }

    @Test
    @DisplayName("Line 객체 boolean 값 확인")
    void line_hasRightMoved_isTrueOrFalse() {
        assertAll(
                () -> assertThat(line.hasRightMoved(0)).isTrue(),
                () -> assertThat(line.hasRightMoved(1)).isFalse(),
                () -> assertThat(line.hasRightMoved(2)).isTrue(),
                () -> assertThat(line.hasRightMoved(3)).isFalse(),
                () -> assertThat(line.hasRightMoved(4)).isFalse()
        );
    }
}
