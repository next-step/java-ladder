package laddergame.v2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {

    @DisplayName("옆 칸과 다리가 겹치면 이동할 수 없다")
    @Test
    void invalid(){
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.first(true).next(true))
                .withMessage("옆 칸과 다리가 겹치면 이동할 수 없습니다");
    }

    @DisplayName("첫번째 칸은 오른쪽 또는 아래로만 내려간다")
    @Test
    void first(){
        Point first1 = Point.first(true);
        Point first2 = Point.first(false);

        assertThat(first1.move()).isEqualTo(Direction.RIGHT);
        assertThat(first2.move()).isEqualTo(Direction.DOWN);
    }

    @DisplayName("첫번째 칸을 기준으로 다음 칸을 생성한다")
    @Test
    void next(){
        Point point = Point.first(true).next(false);

        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("마지막 칸은 왼쪽 또는 아래로만 이동한다")
    @Test
    void last(){
        Point last1 = Point.first(true).next(false).last();
        Point last2 = Point.first(false).next(true).last();

        assertThat(last1.move()).isEqualTo(Direction.DOWN);
        assertThat(last2.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("왼쪽에 다리 없고 현재 칸도 다리가 없으면 아래로 내려간다")
    @Test
    void down(){
        Point point = Point.first(false).next(false);

        assertThat(point.move()).isEqualTo(Direction.DOWN);
    }

    @DisplayName("왼쪽에 다리 있고 현재 칸도 다리가 없으면 왼쪽으로 이동한다")
    @Test
    void left(){
        Point point = Point.first(true).next(false);

        assertThat(point.move()).isEqualTo(Direction.LEFT);
    }

    @DisplayName("왼쪽에 다리 없고 현재 칸도 다리가 있으면 오른쪽으로 이동한다")
    @Test
    void right(){
        Point point = Point.first(false).next(true);

        assertThat(point.move()).isEqualTo(Direction.RIGHT);
    }

}