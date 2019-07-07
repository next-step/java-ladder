package nextstep.ladder;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void isFirstFalsePoint(){
        Point p = Point.first(false);
        assertThat(p.isLeft()).isFalse();
        assertThat(p.isRight()).isFalse();
    }

    @Test
    void isFirstTruePoint(){
        Point p = Point.first(true);
        assertThat(p.isLeft()).isFalse();
        assertThat(p.isRight()).isTrue();
    }

    @Test
    void isLastTruePoint(){
        Point p = Point.first(true);
        p = p.last();
        assertThat(p.isLeft()).isTrue();
        assertThat(p.isRight()).isFalse();
    }

    @Test
    void isMoveRightPoint(){
        Point p = Point.first(false);
        p = p.next(true);
        assertThat(p.isLeft()).isFalse();
        assertThat(p.isRight()).isTrue();
    }

    @Test
    void isMoveLeftPoint(){
        Point p = Point.first(true);
        p = p.next(false);
        assertThat(p.isLeft()).isTrue();
        assertThat(p.isRight()).isFalse();
    }

    @Test
    void isDuplicatePoint(){
        Point p = Point.first(true);
        assertThrows(IllegalArgumentException.class, () -> {
            p.next(true);
        });
    }
}
