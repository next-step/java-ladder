package nextstep.ladder.factory;

import nextstep.ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static nextstep.ladder.TestUtil.asPointList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PointsFactoryTest {

    @Test
    @DisplayName("List<Point> 생성")
    void generate() {
        List<Point> actual = PointsFactory.generate(3, () -> Point.of(false));
        List<Point> expected = asPointList(false, false, false);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("countOfPoints 수만큼 리스트 생성하는지 확인")
    void generate_countOfPoints() {
        List<Point> actual = PointsFactory.generate(4, () -> Point.of(false));
        List<Point> expected = asPointList(false, false, false);

        assertNotEquals(expected.size(), actual.size());
    }
}
