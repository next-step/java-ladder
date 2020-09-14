package nextstep.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.BDDAssertions.then;

class DirectionTest {

    private static final Direction START_TRUE = Direction.getStartDirection(Boolean.TRUE);

    @Test
    void isLeft() {
        then(START_TRUE.isLeft()).isFalse();
    }

    @Test
    void isRight() {
        then(START_TRUE.isRight()).isTrue();
    }

    @Test
    void getStartDirection() {
        then(START_TRUE.isLeft()).isFalse();
        then(START_TRUE.isRight()).isTrue();
    }

    @Test
    void next() {
        then(Direction.of(Boolean.FALSE, Boolean.TRUE).next(Boolean.FALSE))
                .isEqualTo(Direction.of(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    void getLastDirection() {
        then(START_TRUE.getLastDirection()).isEqualTo(Direction.of(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    void getSingleDirection() {
        Direction singleDirection = Direction.getSingleDirection();
        then(singleDirection.isLeft()).isFalse();
        then(singleDirection.isRight()).isFalse();
    }

    @Test
    void of() {
        assertThatThrownBy(() -> Direction.of(Boolean.TRUE, Boolean.TRUE))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("좌측과 우측 모두 페달을 생성할 수 없습니다.");
    }
}
