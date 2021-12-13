package ladder.domain.ladder;

import ladder.strategy.RandomLine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointDirectionTest {

    @Test
    @DisplayName("방향 객체 생성 - 기본값으로 false, false 를 가진다")
    void createDefault() {
        PointDirection direction = new PointDirection();
        assertThat(direction).isEqualTo(new PointDirection());
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isLeft()).isFalse();
    }

    @Test
    @DisplayName("방향 객체 생성 - 방향값 지정해서 생성")
    void create() {
        PointDirection direction = new PointDirection(true, false);
        assertThat(direction).isEqualTo(new PointDirection(true, false));
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isLeft()).isTrue();
    }

    @Test
    @DisplayName("방향 객체 값 검증 - true/true -> IllegalStateException 예외 반환")
    void checkValue() {
        assertThatThrownBy(() -> new PointDirection(true, true))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 true(선이 있다) - 다음 객체 생성은? left:true / right:false")
    void beforeLineTrue() {
        assertThat(PointDirection.createDirection(true, new RandomLine())).isEqualTo(new PointDirection(true,false));
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 false(선이 없다) - 다음 객체 생성은? left:false / right:random(true)")
    void beforeLineFalse1() {
        assertThat(PointDirection.createDirection(false, () -> true)).isEqualTo(new PointDirection(false, true));
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 false(선이 없다) - 다음 객체 생성은? left:false / right:random(false)")
    void beforeLineFalse2() {
        assertThat(PointDirection.createDirection(false, () -> false)).isEqualTo(new PointDirection(false, false));
    }

    @Test
    @DisplayName("라인의 마지막 방향값 생성 - 전 포인트 right(true) -> 다음 객체 생성은? left:true / right:false")
    void createLastDirection1() {
        assertThat(PointDirection.createLastDirection(true)).isEqualTo(new PointDirection(true, false));
    }

    @Test
    @DisplayName("라인의 마지막 방향값 생성 - 전 포인트 right(false) -> 다음 객체 생성은? left:false / right:false")
    void createLastDirection2() {
        assertThat(PointDirection.createLastDirection(false)).isEqualTo(new PointDirection(false, false));
    }

}