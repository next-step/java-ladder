package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @Test
    @DisplayName("생성 테스트")
    void of() {
        assertThatCode(() -> Point.first(true)).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("first() 호출 시  left는 항상 false 이다.")
    public void first() {
        Point point = Point.first(true);
        assertAll(
                () -> assertEquals(point.getDirection().isLeft(), false),
                () -> assertEquals(point.getDirection().isRight(), true)
        );
    }

    @Test
    @DisplayName("Point 생성 후 이동 position 확인_first(true) 생성 후 next() 호출 시 인덱스는 -1이 된다")
    public void next() {
        Point second = Point.first(true).next();
        assertThat(second.move()).isEqualTo(0);
    }

    @Test
    @DisplayName("last() 를 호출하면 rigth은 항상 false이다")
    public void last() {
        Point point = Point.first(true).last();
        assertAll(
                () -> assertEquals(point.getDirection().isRight(), false),
                () -> assertEquals(point.getDirection().isLeft(), true)

        );
    }

}
