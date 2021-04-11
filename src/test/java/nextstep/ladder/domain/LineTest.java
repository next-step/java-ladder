package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LineTest {

    @Test
    void create() {
        assertThatCode(() -> Line.from(5, new RandomBooleanStrategy())).doesNotThrowAnyException();
    }

    @Test
    void points() {
        List<Point> points = new ArrayList<>();
        points.add(Point.from(true));
        points.add(Point.from(false));
        points.add(Point.from(true));
        points.add(Point.from(false));

        assertThat(Line.from(5, () -> true).points()).usingRecursiveComparison().isEqualTo(points);
    }

    @DisplayName("가로라인은 겹치지 않아야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {5, 10, 100})
    void pointsNotContinuousTrue(int countOfPerson) {
        List<Point> points = Line.from(countOfPerson, new RandomBooleanStrategy()).points();

        for (int i = 0; i < points.size(); i++) {
            if (i == 0) {
                continue;
            }
            if (points.get(i - 1).value()) {
                assertThat(points.get(i)).usingRecursiveComparison().isEqualTo(Point.from(false));
            }
        }
    }
}
