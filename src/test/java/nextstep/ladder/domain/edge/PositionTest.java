package nextstep.ladder.domain.edge;

import nextstep.ladder.domain.line.Line;
import nextstep.ladder.domain.line.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @DisplayName("Position 인스턴스 생성")
    @Test
    public void testConstructor() {
        assertDoesNotThrow(() -> new Position(1));
    }

    @DisplayName("Position 인스턴스 생성 - 음수 값은 들어갈 수 없음")
    @Test
    public void testConstructor_throwException () {
        assertThatThrownBy(() -> new Position(-1))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("위치 값은 0 이하가 될 수 없습니다.");
    }

    @DisplayName("왼쪽으로 움직일 수 있음")
    @Test
    public void testCanMoveLeft_True() {
        Line line = new Line(List.of(new Point(true), new Point(false)));

        assertThat(new Position(1).canMoveLeft(line)).isTrue();
    }

    @DisplayName("왼쪽으로 움직이지 못함")
    @Test
    public void testCanMoveLeft_False() {
        Line line = new Line(List.of(new Point(true), new Point(false)));

        assertAll(
            () -> assertThat(new Position(0).canMoveLeft(line)).isFalse(),
            () -> assertThat(new Position(2).canMoveLeft(line)).isFalse()
        );
    }

    @DisplayName("오른쪽으로 움직일 수 있음")
    @Test
    public void testCanMoveRight_True() {
        Line line = new Line(List.of(new Point(true), new Point(false)));

        assertThat(new Position(0).canMoveRight(line)).isTrue();
    }

    @DisplayName("오른쪽으로 움직이지 못함")
    @Test
    public void testCanMoveRight_False() {
        Line line = new Line(List.of(new Point(true), new Point(false)));

        assertAll(
            () -> assertThat(new Position(1).canMoveRight(line)).isFalse(),
            () -> assertThat(new Position(2).canMoveRight(line)).isFalse()
        );
    }

    @DisplayName("왼쪽으로 이동")
    @Test
    public void testMoveLeft() {
        assertThat(new Position(1).moveLeft()).isEqualTo(new Position(0));
    }

    @DisplayName("오른쪽으로 이동")
    @Test
    public void testMoveRight() {
        assertThat(new Position(1).moveRight()).isEqualTo(new Position(2));
    }
}
