package nextstep.ladder;

import nextstep.ladder.model.Line;
import nextstep.ladder.model.Point;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LineTest {
    @Test
    @DisplayName("line 생성")
    void createLineTest() {
        //given
        Line line = new Line(4, new MockLineGenerator());

        //when
        List<Point> points = line.getPoints();

        //then
        Assertions.assertThat(points).hasSize(3);
        List<Point> expectedPoints = new ArrayList<>(List.of(new Point(true), new Point(false), new Point(true)));
        Assertions.assertThat(points).hasSameElementsAs(expectedPoints);
    }
}
