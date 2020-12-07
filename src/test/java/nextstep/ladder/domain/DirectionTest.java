package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class DirectionTest {

    @DisplayName("Direction Exception Test - 양방향으로 갈수 없음")
    @Test
    public void directionExceptionTest() {
        assertThatThrownBy(() -> {
            Direction.of(true, true);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫번째로 나올수있는 방향 테스트")
    @RepeatedTest(10)
    public void generateFirstDirectionTest() {
        Direction direction = Direction.generateFirst();
        assertThat(direction).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막으로 올수있는 방향 테스트 - 이전 방향이 왼쪽")
    @RepeatedTest(10)
    public void generateLastDirectionTestBeforeLeft() {
        Direction direction = Direction.generateLast(Direction.LEFT);
        assertAll(
                () -> assertThat(direction).isEqualTo(Direction.NONE),
                () -> assertThat(direction).isNotEqualTo(Direction.LEFT)
        );
    }

    @DisplayName("마지막으로 올수있는 방향 테스트 - 이전 방향이 오른쪽")
    @RepeatedTest(10)
    public void generateLastDirectionTestBeforeRight() {
        Direction direction = Direction.generateLast(Direction.RIGHT);
        assertAll(
                () -> assertThat(direction).isEqualTo(Direction.LEFT),
                () -> assertThat(direction).isNotEqualTo(Direction.NONE),
                () -> assertThat(direction).isNotEqualTo(Direction.RIGHT)
        );
    }

    @DisplayName("이전 방향이 왼쪽")
    @Test
    @RepeatedTest(10)
    public void nextDirectionTestBeforeLeft(){
        Direction direction = Direction.generateLast(Direction.LEFT);
        assertThat(direction).isNotEqualTo(Direction.LEFT);
    }

    @DisplayName("이전 방향이 오른쪽")
    @Test
    public void nextDirectionTestBeforeRight(){
        Direction direction = Direction.next(Direction.RIGHT);
        assertAll(
                () -> assertThat(direction).isEqualTo(Direction.LEFT),
                () -> assertThat(direction).isNotEqualTo(Direction.NONE),
                () -> assertThat(direction).isNotEqualTo(Direction.RIGHT)
        );
    }

}
