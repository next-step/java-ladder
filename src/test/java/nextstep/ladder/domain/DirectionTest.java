package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DirectionTest {

    @DisplayName("방향을 생성한다")
    @Test
    void initTest() {
        assertThat(Direction.of(true, false)).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("양방향일 경우 에러를 반환한다")
    @Test
    public void initInvalidTest() {
        assertThatThrownBy(() -> Direction.of(true, true)).isInstanceOf(IllegalAccessException.class);
    }

    @DisplayName("연결한 방향의 다음을 자동으로 생성한다")
    @Test
    public void nextDirectionTest() {
        Direction next = Direction.first(true).next();
        assertThat(next).isEqualTo(Direction.of(true, false));
    }

    @DisplayName("첫번째 지점의 방향을 생성한다")
    @Test
    public void firstTest() {
        Direction first = Direction.first(true);
        assertThat(first.isLeft()).isEqualTo(false);
    }

    @DisplayName("마지막 지점의 방향을 생성한다")
    @Test
    public void last() {
        Direction last = Direction.first(true).last();
        assertThat(last).isEqualTo(Direction.of(true, false));
    }
}
