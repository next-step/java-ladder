package nextstep.step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("처음 위치하는 점에서 move 메서드 호출 시 이동한 위치")
    void firstPointMove() {
        assertThat(Point.first(false).move()).isEqualTo(0);
        assertThat(Point.first(true).move()).isEqualTo(1);
    }

    @Test
    @DisplayName("2번째에 오는 점에서 양방향으로 이동할 수 없을 때 가만히 있어야 함")
    void nextPointStay() {
        Point secondPoint = Point.first(false).next(false);
        assertThat(secondPoint.move()).isEqualTo(1);
    }

    @Test
    @DisplayName("2번째에 오는 점이 isLeft 가능할 경우 움직였을 때 처음 column 으로 이동해야 함")
    void nextPointLeftMove() {
        Point secondPoint = Point.first(true).next(false);
        assertThat(secondPoint.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("2번째에 오는 점이 isRight 가능할 경우 움직였을 때 세 번째 column 으로 이동해야 함")
    void nextPointRightMove() {
        Point secondPoint = Point.first(false).next(true);
        assertThat(secondPoint.move()).isEqualTo(2);
    }

    @Test
    @DisplayName("처음 위치 isRight, 두 번째 위치를 Generator 를 사용하여도 좌측으로 이동하게 만들어짐")
    void randomNextPointMoveLeft() {
        Point secondPoint = Point.first(true).next();
        assertThat(secondPoint.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("마지막 위치 이동은 이전 Point 클래스의 right 에 영향을 받는다")
    void lastPointMove() {
        assertAll(
                () -> assertThat(Point.first(false).last().move()).isOne(),
                () -> assertThat(Point.first(true).last().move()).isZero()
        );
    }
}