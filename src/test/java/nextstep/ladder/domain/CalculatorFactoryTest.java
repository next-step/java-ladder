package nextstep.ladder.domain;

import nextstep.ladder.domain.calculator.CalculatorFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("라인 개수를 구하는 객체 생성 팩토리 테스트")
public class CalculatorFactoryTest {

    @DisplayName("참가자 수에 따라 가로, 세로 라인의 개수를 구한다.")
    @Test
    void calculate() {
        int participantCount = 4;
        Assertions.assertThat(new CalculatorFactory().calculate("ROW", participantCount)).isLessThan(4);
        Assertions.assertThat(new CalculatorFactory().calculate("COLUMN", participantCount)).isEqualTo(participantCount);
    }
}
