package ladder.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static ladder.model.Direction.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

public class LineTest {
    @Test
    void testSuccessCreateLine() {
        List<Boolean> points = List.of(true, false, false);

        assertThatNoException().isThrownBy(() -> {
            Line line = new Line(points);
            assertThat(line.get(0)).isEqualTo(RIGHT);
            assertThat(line.get(1)).isEqualTo(LEFT);
            assertThat(line.get(2)).isEqualTo(DOWN);
        });

    }

    @Test
    void testDuplicatePointException() {
        List<Boolean> points = List.of(true, true, true, false);

        assertThatIllegalArgumentException().isThrownBy(() -> new Line(points));
    }

    @Test
    void testInCorrectSizeException() {
        List<Boolean> points1 = List.of();
        List<Boolean> points2 = List.of(true);

        assertThatIllegalArgumentException().isThrownBy(() -> new Line(points1));
        assertThatIllegalArgumentException().isThrownBy(() -> new Line(points2));
    }

    @Test
    void Given_Last_Point_Is_True_When_Create_Line_Then_Fail() {
        List<Boolean> points = List.of(true, false, true);

        assertThatIllegalArgumentException().isThrownBy(() -> new Line(points));
    }
}
