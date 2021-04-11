package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Test
    void create() {
        assertThatCode(() -> Line.from(5, new RandomBooleanStrategy())).doesNotThrowAnyException();
    }

    @DisplayName("가로라인은 겹치지 않아야 한다.")
    @Test
    void points() {
        List<Point> points = new ArrayList<>();
        points.add(Point.from(true));
        points.add(Point.from(false));
        points.add(Point.from(true));
        points.add(Point.from(false));

        assertThat(Line.from(5, () -> true)).usingRecursiveComparison().isEqualTo(Line.from(points));
    }
}
