package nextstep.refactoring.ladder.concrete;

import nextstep.refactoring.ladder.engine.Line;
import nextstep.refactoring.ladder.engine.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderLineTest {

    @Test
    @DisplayName("최소 두 개의 지점이 있어야 한다.")
    void lineHasPointsAtLeastTwo() {
        assertAll(
            () -> assertThatThrownBy(() -> LadderLine.of(Point.of(0, Direction.right()))),
            () -> assertThatThrownBy(() -> LadderLine.of(Collections.emptyList()))
        );
    }

    @Test
    @DisplayName("현재 위치에서 연결된 지점이 있는 경우 이동한다.")
    void movePoint() {
        Point first = Point.of(0, Direction.right());
        Point second = first.next();
        Line line = LadderLine.of(first, second);

        assertThat(line.move(Position.of(0))).isEqualTo(Position.of(1));
    }

    @Test
    @DisplayName("라인의 길이를 반환한다.")
    void getWidth() {
        Point first = Point.of(0, Direction.right());
        Point second = first.next();
        Point third = second.next();

        Line line = LadderLine.of(first, second, third);

        assertThat(line.getWidth()).isEqualTo(3);
    }

    @Test
    @DisplayName("라인의 특정 지점이 우측 지점과 연결되어 있는지 확인한다.")
    void name() {
        Point first = Point.of(0, Direction.right());
        Point second = first.next();
        Point third = Point.of(2, Direction.straight());

        Line line = LadderLine.of(first, second, third);

        assertAll(
            () -> assertThat(line.isConnectedToRight(Position.of(0))).isTrue(),
            () -> assertThat(line.isConnectedToRight(Position.of(1))).isFalse(),
            () -> assertThat(line.isConnectedToRight(Position.of(2))).isFalse()
        );
    }

}
