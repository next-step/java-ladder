package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

public class PointTest {

    @Test
    @DisplayName("첫 사다리의 오른쪽 방향 설정을 검증한다.")
    void firstPoint() {
        assertThat(Point.first(TRUE).right()).isTrue();
        assertThat(Point.first(FALSE).right()).isFalse();
    }

    @Test
    @DisplayName("첫 사다리의 오른쪽 방향이 TRUE라면, 다음 사다리는 FALSE로 설정된다.")
    void secondPoint() {
        assertThat(Point.first(TRUE).next().right()).isFalse();
    }

    @Test
    @DisplayName("마지막 사다리의 왼쪽 방향은 그 전 사다리의 오른쪽 방향 값이고, 오른쪽 방향은 FALSE이다.")
    void lastPoint() {
        assertThat(Point.first(TRUE).last().left()).isTrue();
        assertThat(Point.first(FALSE).last().left()).isFalse();
        assertThat(Point.first(TRUE).last().right()).isFalse();
    }
}
