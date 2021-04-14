package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @DisplayName("방향을 생성한다")
    @Test
    void initTest() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("양방향일 경우 에러를 반환한다")
    @Test
    public void initInvalidTest() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE)).isInstanceOf(IllegalStateException.class);
    }

    @DisplayName("연결한 방향의 다음을 자동으로 생성한다")
    @Test
    public void nextDirectionTest() {
        Direction next = Direction.first(TRUE).next();
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("첫번째 지점의 방향을 생성한다")
    @Test
    public void firstTest() {
        Direction first = Direction.first(TRUE);
        assertThat(first.isLeft()).isEqualTo(FALSE);
    }

    @DisplayName("마지막 지점의 방향을 생성한다")
    @Test
    public void last() {
        Direction last = Direction.first(TRUE).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }
}
