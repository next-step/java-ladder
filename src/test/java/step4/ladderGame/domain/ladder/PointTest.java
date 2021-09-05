package step4.ladderGame.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.ladderGame.domain.ladder.GenerateDirectionStrategy.GenerateRandomDirectionStrategy;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

class PointTest {

    @DisplayName("첫번째 포인트에서 이동")
    @Test
    public void first() {
        assertThat(Point.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return true;
            }
        }).move()).isEqualTo(1);
        assertThat(Point.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return false;
            }
        }).move()).isEqualTo(0);
    }

    @DisplayName("좌우 길이 FALSE/FALSE 일 경우 index 를 유지한다.")
    @Test
    public void next_stay() {
        Point second = Point.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return false;
            }
        }).next(FALSE);
        assertThat(second.move()).isEqualTo(1);
    }

    @DisplayName("좌우 길이 TRUE/FALSE 일 경우 왼쪽으로 이동한다. (index--)")
    @Test
    public void next_left() {
        Point second = Point.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return true;
            }
        }).next(FALSE);
        assertThat(second.move()).isEqualTo(0);
    }

    @DisplayName("좌우 길이 FALSE/TRUE 일 경우 오른쪽으로 이동한다. (index++)")
    @Test
    public void next_right() {
        Point second = Point.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return false;
            }
        }).next(TRUE);
        assertThat(second.move()).isEqualTo(2);
    }

    @DisplayName("좌우 길이 FALSE/TRUE 일 경우 오른쪽으로 이동한다. Random (index++)")
    @Test
    public void next() {
        Point second = Point.first(new GenerateRandomDirectionStrategy() {
            public boolean generateDirection() {
                return true;
            }
        }).next(new GenerateRandomDirectionStrategy());
        assertThat(second.move()).isEqualTo(0);
    }

}
