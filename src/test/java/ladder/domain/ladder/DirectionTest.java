package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {

    @Test
    @DisplayName("방향 객체 생성 - 기본값으로 false, false 를 가진다")
    void createDefault() {
        Direction direction = new Direction();
        assertThat(direction).isEqualTo(new Direction());
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    @DisplayName("방향 객체 생성 - 방향값 지정해서 생성")
    void create() {
        Direction direction = new Direction(true, false);
        assertThat(direction).isEqualTo(new Direction(true, false));
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isLeft()).isTrue();
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 true(선이 있다) - 다음 객체 생성은? left:false / right:true")
    void beforeLineTrue() {
        assertThat(Direction.createDirection(true, new RandomLadder())).isEqualTo(new Direction(true,false));
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 false(선이 없다) - 다음 객체 생성은? left:false / right:random(true)")
    void beforeLineFalse1() {
        assertThat(Direction.createDirection(false, () -> true)).isEqualTo(new Direction(false, true));
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 false(선이 없다) - 다음 객체 생성은? left:false / right:random(false)")
    void beforeLineFalse2() {
        assertThat(Direction.createDirection(false, () -> false)).isEqualTo(new Direction(false, false));
    }

}