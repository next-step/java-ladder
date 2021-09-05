package step4.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateRandomDirectionStrategy;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class DirectionTest {

    @DisplayName("두 객체 비교")
    @Test
    public void init() {
        assertThat(Direction.of(TRUE, FALSE)).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("오른쪽, 왼쪽길이 동시에 있을 수 는 없다.")
    @Test
    public void init_invalid() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Direction.of(TRUE, TRUE);
        }).withMessageMatching("오른쪽, 왼쪽길이 동시에 있을 수 는 없습니다.");
    }

    @DisplayName("현재 방향이 FALSE/TRUE 이면 다음 오른쪽 방향을 랜덤생성해도 결과는 FALSE 다.")
    @Test
    public void next_random_true() {
        Direction next = Direction.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return true;
            }
        }).next(new GenerateRandomDirectionStrategy());
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("현재 방향 TRUE, FALSE 에서 다음 방향을 FALSE/TRUE 로 생성한다.")
    @Test
    public void next_true() {
        Direction next = Direction.of(TRUE, FALSE).next(TRUE);
        assertThat(next).isEqualTo(Direction.of(FALSE, TRUE));
    }

    @DisplayName("현재 방향 FALSE, TRUE 에서 다음 방향을 TRUE/FALSE 로 생성한다.")
    @Test
    public void next_false() {
        Direction next = Direction.of(FALSE, TRUE).next(FALSE);
        assertThat(next).isEqualTo(Direction.of(TRUE, FALSE));
    }

    @DisplayName("첫번째 방향은 왼쪽길이 없는 FALSE/TRUE 이다.")
    @Test
    public void first() {
        Direction first = Direction.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return true;
            }
        });
        assertThat(first.isLeft()).isFalse();
    }

    @DisplayName("마지막 방향은 왼쪽길이 없는 FALSE/TRUE 이다.")
    @Test
    public void last() {
        Direction last = Direction.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return true;
            }
        }).last();
        assertThat(last).isEqualTo(Direction.of(TRUE, FALSE));
    }

}
