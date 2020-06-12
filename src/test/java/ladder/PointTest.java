package ladder;

import ladder.domain.Direction;
import ladder.domain.LadderBuildingException;
import ladder.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class PointTest {

    private static Stream<Arguments> mockDirectionBuilder() {
        return Stream.of(
                Arguments.of(0, Direction.LEFT),
                Arguments.of(1, Direction.RIGHT),
                Arguments.of(2, Direction.DOWN)
        );
    }

    @DisplayName("Point 객체 생성 성공 테스트")
    @Test
    public void makePointObject() {
        assertThatCode(() -> {
            new Point(0, Direction.RIGHT);
        }).doesNotThrowAnyException();
    }

    @DisplayName("Point 객체 생성 실패 테스트(음수값)")
    @Test
    public void throwExceptionOnMakingPointObject() {
        assertThatThrownBy(() -> {
            new Point(-3, Direction.LEFT);
        }).isInstanceOf(LadderBuildingException.class)
                .hasMessageContaining(LadderBuildingException.NEGATIVE_INDEX);
    }

    @DisplayName("1개 Line의 처음 점을 찍는 메소드 테스트")
    @Test
    public void drawFirstPoint() {
        Point pointWithDownDirection = Point.drawFirstPoint(true);
        Point pointWithRightDirection = Point.drawFirstPoint(false);

        assertThat(pointWithDownDirection.getDirection()).isEqualTo(Direction.DOWN);
        assertThat(pointWithRightDirection.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("이전 Point의 방향이 Right이면 그 다음 Point의 방향은 Left가 됨")
    @Test
    public void pointLeftWhenLastPointRight() {
        Point lastPoint = new Point(0, Direction.RIGHT);

        Point nextPoint = Point.drawMiddlePoint(lastPoint, false);

        assertThat(nextPoint.getDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("이전 Point의 방향이 Right가 아니면 random boolean에 의해 방향이 결정됨")
    @Test
    public void pointRandomWhenLastPointNotRight() {
        Point lastPoint = new Point(0, Direction.DOWN);

        Point nextDownPoint = Point.drawMiddlePoint(lastPoint, true);
        Point nextRightPoint = Point.drawMiddlePoint(lastPoint, false);

        assertThat(nextDownPoint.getDirection()).isEqualTo(Direction.DOWN);
        assertThat(nextRightPoint.getDirection()).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("Line의 마지막 점을 찍을 때 이전 Point가 Left면 Down으로 찍힘")
    @Test
    public void drawLastDownPoint() {
        Point lastLeftPoint = new Point(3, Direction.LEFT);
        Point pointWithDownDirection = Point.drawLastPoint(lastLeftPoint);

        assertThat(pointWithDownDirection.getDirection()).isEqualTo(Direction.DOWN);
    }

    @DisplayName("Line의 마지막 점을 찍을 때 이전 Point가 Right면 Left로 찍힘")
    @Test
    public void drawLastLeftPoint() {
        Point lastRightPoint = new Point(3, Direction.RIGHT);
        Point pointWithLeftDirection = Point.drawLastPoint(lastRightPoint);

        assertThat(pointWithLeftDirection.getDirection()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("Direction이 Right일때 Index는 상승")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 5})
    public void moveRight(int index) {
        Point point = new Point(index, Direction.RIGHT);

        assertThat(point.moveByDirection()).isEqualTo(index + 1);
    }

    @DisplayName("Direction이 Leftt일때 Index는 상승")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    public void moveLeft(int index) {
        Point point = new Point(index, Direction.LEFT);

        assertThat(point.moveByDirection()).isEqualTo(index - 1);
    }

    @DisplayName("Direction이 Down일때 Index는 변화없음")
    @ParameterizedTest
    @ValueSource(ints = {0, 3, 5})
    public void moveDown(int index) {
        Point point = new Point(index, Direction.DOWN);

        assertThat(point.moveByDirection()).isEqualTo(index);
    }
}
