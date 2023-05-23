package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PointTest {
    @DisplayName("Point객체 생성 테스트_정상")
    @ParameterizedTest
    @CsvSource({"false,false", "false,true", "true,false"})
    void Point객체_생성_정상(boolean canMoveToLeft, boolean canMoveToRight) {
        Point point = Point.create(canMoveToLeft, canMoveToRight);
        assertThat(point.canMoveToLeft()).isEqualTo(canMoveToLeft);
        assertThat(point.canMoveToRight()).isEqualTo(canMoveToRight);
    }

    @DisplayName("Point객체 생성_가로라인이 겹치는 경우")
    @Test
    void Point객체_생성_가로라인이_겹치는_경우() {
        Point current = Point.create(false, true);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.create(current.canMoveToRight(), current.canMoveToRight()))
                .withMessageMatching("가로 라인이 겹칠 수 없습니다.");
    }

    @DisplayName("Point객체 생성(정적팩토리메서드)_검증")
    @ParameterizedTest
    @CsvSource({"true,true"})
    void 양방향모두_가능하게_생성되면_안됨(boolean canMoveToLeft, boolean canMoveToRight) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Point.create(canMoveToLeft, canMoveToRight))
                .withMessageMatching("가로 라인이 겹칠 수 없습니다.");
    }

    @DisplayName("Point객체 생성 테스트_첫번째생성의 경우")
    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void 첫번째생성_왼쪽으로는_갈수없다(boolean input) {
        Point point = Point.createFirst(input);
        assertThat(point.canMoveToLeft()).isFalse();
        assertThat(point.canMoveToRight()).isEqualTo(input);
    }

    @DisplayName("Point객체 생성 테스트_중간생성의 경우")
    @ParameterizedTest
    @CsvSource({"false,false", "false,true", "true,false"})
    void 중간생성_가로라인이_겹치면_안된다(boolean canMoveToLeft, boolean canMoveToRight) {
        Point point = Point.createNext(canMoveToLeft, canMoveToRight);
        assertThat(point.canMoveToLeft()).isEqualTo(canMoveToLeft);
        assertThat(point.canMoveToRight()).isEqualTo(canMoveToRight);
    }

    @DisplayName("Point객체 생성 테스트_마지막생성의 경우")
    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    void 마지막생성_오른쪽으로는_갈수없다(boolean input) {
        Point point = Point.createLast(input);
        assertThat(point.canMoveToLeft()).isEqualTo(input);
        assertThat(point.canMoveToRight()).isFalse();
    }
}
