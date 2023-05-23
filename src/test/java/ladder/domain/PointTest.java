package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
