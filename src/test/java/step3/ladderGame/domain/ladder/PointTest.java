package step3.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointTest {

    @DisplayName("생성")
    @Test
    void create() {
        assertAll(
                () -> assertThat(Point.generateFirstPoint()).isInstanceOf(Point.class),
                () -> assertThat(Point.generatePoint(Point.generateFirstPoint())).isInstanceOf(Point.class),
                () -> assertThat(Point.generateLastPoint(Point.generateFirstPoint())).isInstanceOf(Point.class)
        );
    }

}
