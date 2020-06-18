package ladder;

import ladder.domain.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class DirectionTest {

    private static Stream<Arguments> mockDirectionBuilder() {
        return Stream.of(
                Arguments.of(0, Direction.LEFT),
                Arguments.of(1, Direction.RIGHT),
                Arguments.of(2, Direction.DOWN)
        );
    }

    @DisplayName("Direction Enum 객체 정상 생성 테스트")
    @ParameterizedTest
    @MethodSource("mockDirectionBuilder")
    public void direction_정상_생성(int index, Direction expectedDirection) {
        Direction direction = Direction.values()[index];

        assertThat(direction).isEqualTo(expectedDirection);
    }

    @DisplayName("Direction이 LEFT면 index의 값을 1 마이너스")
    @Test
    public void moveIndexByDirection_왼쪽() {
        int result = Direction.LEFT.moveIndexByDirection(3);

        assertThat(result).isEqualTo(2);
    }

    @DisplayName("Direction이 RIGHT면 index의 값을 1 플러스")
    @Test
    public void moveIndexByDirection_오른쪽() {
        int result = Direction.RIGHT.moveIndexByDirection(3);

        assertThat(result).isEqualTo(4);
    }

    @DisplayName("Direction이 Down이면 index의 값 변화 없음")
    @Test
    public void moveIndexByDirection_아래쪽() {
        int result = Direction.DOWN.moveIndexByDirection(3);

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("Direiction에게 첫 번째 점의 방향을 요청 : 오른쪽 방향")
    @Test
    public void directionFirst_오른쪽() {
        Direction direction = Direction.first(false);

        assertThat(direction).isEqualTo(Direction.RIGHT);
    }

    @DisplayName("Direiction에게 첫 번째 점의 방향을 요청 : 아래 방향")
    @Test
    public void directionFirst_아래쪽() {
        Direction direction = Direction.first(true);

        assertThat(direction).isEqualTo(Direction.DOWN);
    }

    @DisplayName("Direction에게 마지막 점의 방향을 요청 : 이전 점의 방향이 Right인 경우 왼쪽 방향 반환")
    @Test
    public void directionLast_왼쪽() {
        Direction beforeDirection = Direction.RIGHT;
        Direction lastDirection = beforeDirection.last();

        assertThat(lastDirection).isEqualTo(Direction.LEFT);
    }

    @DisplayName("Direction에게 마지막 점의 방향을 요청 : 이전 점의 방향이 Down이거나 Left인 경우 아래쪽 방향 반환")
    @Test
    public void directionLast_아래쪽() {
        Direction beforeDirection = Direction.LEFT;
        Direction lastDirection = beforeDirection.last();

        assertThat(lastDirection).isEqualTo(Direction.DOWN);

        beforeDirection = Direction.DOWN;
        lastDirection = beforeDirection.last();

        assertThat(lastDirection).isEqualTo(Direction.DOWN);
    }

    @DisplayName("Direction에게 다음 중간 점의 방향을 요청 : 이전 점의 방향이 Right인 경우 어떤 경우에도 왼쪽 방향 반환")
    @Test
    public void directionNext_왼쪽() {
        Direction lastDirection = Direction.RIGHT;

        Direction nextDirection = lastDirection.next(true);
        Direction nextDirection2 = lastDirection.next(false);

        assertThat(nextDirection).isEqualTo(Direction.LEFT);
        assertThat(nextDirection2).isEqualTo(Direction.LEFT);
    }

    @DisplayName("Direction에게 다음 중간 점의 방향을 요청 : 이전 점의 방향이 Right가 아니면 boolean에 따라 아래 혹은 오른쪽 반환")
    @Test
    public void directionNext_아래_혹은_오른쪽() {
        Direction lastDirection = Direction.LEFT;

        Direction nextDirection = lastDirection.next(true);
        Direction nextDirection2 = lastDirection.next(false);

        assertThat(nextDirection).isEqualTo(Direction.DOWN);
        assertThat(nextDirection2).isEqualTo(Direction.RIGHT);
    }
}
