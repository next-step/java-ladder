package ladder.domain;

import ladder.domain.test.FailedMakePointsStrategy;
import ladder.domain.test.ForceMakePointsStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @Test
    @DisplayName("[요구사항 1] 연속된 가로줄이 생성되도록 하는 라인 제작 전략을 채택할 경우 throw IllegalArgumentException")
    void 요구사항_1() {
        // given
        int countOfPerson = 3;

        // when
        FailedMakePointsStrategy failedMakePointsStrategy = new FailedMakePointsStrategy();

        // then
        assertThatThrownBy(() -> new Line(countOfPerson, failedMakePointsStrategy))
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("연속된 가로줄은 허용하지 않습니다.");
    }

    @Test
    @DisplayName("[요구사항 2] 각 라인 당 TFTF로 만드는 전략을 사용할 경우, index 2의 다음 행선지는 3이다. (우측 이동) / countOfPerson 짝수 주의")
    void 요구사항_2() {
        // given
        int countOfPerson = 4;
        int currentIndex = 2;
        int expectedNextIndex = 3;

        // when
        ForceMakePointsStrategy forceMakePointsStrategy = new ForceMakePointsStrategy();
        Line line = new Line(countOfPerson, forceMakePointsStrategy);

        // then
        assertThat(line.findNextIndex(currentIndex)).isEqualTo(expectedNextIndex);
    }

    @Test
    @DisplayName("[요구사항 3] 각 라인 당 TFTF로 만드는 전략을 사용할 경우, index 3의 다음 행선지는 2이다. (좌측 이동) / countOfPerson 짝수 주의")
    void 요구사항_3() {
        // given
        int countOfPerson = 4;
        int currentIndex = 3;
        int expectedNextIndex = 2;

        // when
        ForceMakePointsStrategy forceMakePointsStrategy = new ForceMakePointsStrategy();
        Line line = new Line(countOfPerson, forceMakePointsStrategy);

        // then
        assertThat(line.findNextIndex(currentIndex)).isEqualTo(expectedNextIndex);
    }
}
