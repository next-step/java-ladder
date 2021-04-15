package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class PointTest {

    @Test
    @DisplayName("연결된 지점으로 이동한다.")
    void traverse() {
        Point firstPoint = Point.of(0, Direction.right());
        Point secondPoint = firstPoint.next();
        Point thirdPoint = secondPoint.last();

        assertAll(
            () -> assertThat(firstPoint.traverse()).isEqualTo(Position.of(1)),
            () -> assertThat(secondPoint.traverse()).isEqualTo(Position.of(0)),
            () -> assertThat(thirdPoint.traverse()).isEqualTo(Position.of(2))
        );
    }

}
