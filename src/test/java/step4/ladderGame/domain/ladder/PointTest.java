package step4.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.ladderGame.domain.ladder.pointGenerationStrategy.LadderLineRandomGenerationStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointTest {

    @DisplayName("생성")
    @Test
    void create() {
        List<Point> points = Point.generateFirstPoint();
        assertAll(
                () -> assertThat(Point.generatePoint(points.get(0), new LadderLineRandomGenerationStrategy())).isInstanceOf(Point.class),
                () -> assertThat(Point.generateLastPoint(points.get(0))).isInstanceOf(Point.class)
        );
    }

}
