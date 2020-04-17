package ladder.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DirectionTest {

    @DisplayName("좌우 방향 값을 같는 Direction 을 초기화 할 수 있다")
    @Test
    public void init() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("Direction 의 좌, 우 값은 같은 상태를 가질 수 없습니다.")
    @Test
    public void initInvalid() {
        assertThatThrownBy(() -> Direction.of(TRUE, TRUE))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫번째 Direction 의 왼쪽은 FALSE 만 허용된다")
    @Test
    public void generateFirst() {
        assertThat(Direction.generateFirst(TRUE)).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @DisplayName("이전 방향에 기반으로 다음 방향을 생성한다")
    @Test
    public void nextGenerateFalse() {
        Direction next = Direction.generateFirst(TRUE).generateNext(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("마지막 Direction 의 오른쪽은 FALSE 만 허용된다")
    @Test
    public void generateLast() {
        Direction generatedLast = Direction.generateFirst(TRUE).generateLast();
        assertThat(generatedLast).isEqualTo(Direction.of(TRUE, FALSE));
    }

}
