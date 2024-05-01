package nextstep.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @DisplayName("양옆에 라인이 없다면 제자리를 유지한다.")
    @Test
    void cantMovePosition() {
        Position position = new Position(1);
        Position movedPosition = position.move(new Line(List.of(false, false)));
        assertThat(movedPosition).isEqualTo(position);
    }

    @DisplayName("0을 제외한 포지션은 왼쪽으로 움직일 수 있다.")
    @Test
    void canMoveLeftPosition() {
        Position position = new Position(0);
        Position movedPosition = position.move(new Line(List.of(false, true)));
        assertThat(movedPosition).isEqualTo(position);

        Position canMovePosition = new Position(2);
        Position canMovedPosition = canMovePosition.move(new Line(List.of(false, true)));
        assertThat(canMovedPosition).isEqualTo(new Position(1));
    }

    @DisplayName("마지막 위치에 있는 포지션을  제외하고 포지션은 오른쪽으로 움직일 수 있다.")
    @Test
    void canMoveRightPosition() {
        Position position = new Position(0);
        Position movedPosition = position.move(new Line(List.of(true, false)));
        assertThat(movedPosition).isEqualTo(new Position(1));

        Position canMovePosition = new Position(2);
        Position canMovedPosition = canMovePosition.move(new Line(List.of(true, false)));
        assertThat(canMovedPosition).isEqualTo(canMovePosition);
    }
}
