package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointDirectionTest {

    @Test
    @DisplayName("방향 객체 생성 - 방향값 지정해서 생성")
    void create() {
        PointDirection direction = PointDirection.of(true, false);
        assertThat(direction).isEqualTo(PointDirection.of(true, false));
        assertThat(direction.isRight()).isFalse();
        assertThat(direction.isLeft()).isTrue();
    }

    @Test
    @DisplayName("방향 객체 값 검증 - true/true -> IllegalStateException 예외 반환")
    void checkValue() {
        assertThatThrownBy(() -> PointDirection.of(true, true))
                .isInstanceOf(IllegalStateException.class);
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 true(선이 있다) - 다음 객체 생성은? left:true / right:false")
    void beforeLineTrue() {
        PointDirection before = PointDirection.of(false, true);
        PointDirection after = PointDirection.of(true, false);
        assertThat(PointDirection.next(before, false)).isEqualTo(after);
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 false(선이 없다) - 다음 객체 생성은? left:false / right:random(true)")
    void beforeLineFalse1() {
        PointDirection before = PointDirection.of(false, false);
        PointDirection after = PointDirection.of(false, true);
        assertThat(PointDirection.next(before, true)).isEqualTo(after);
    }

    @Test
    @DisplayName("전 포인트 객체 right 값이 false(선이 없다) - 다음 객체 생성은? left:false / right:random(false)")
    void beforeLineFalse2() {
        PointDirection before = PointDirection.of(false, false);
        PointDirection after = PointDirection.of(false, false);
        assertThat(PointDirection.next(before, false)).isEqualTo(after);
    }

}