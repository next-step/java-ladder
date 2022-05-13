package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import nextstep.ladder.strategy.FixedLadderLineProduction;
import nextstep.ladder.strategy.ProductionStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LadderTest {

    @Test
    @DisplayName("사다리 라인이 연달아 있는 경우, 예외처리를 한다.")
    void exceptionLadderLineConsecutive() {
        // given
        int countOfParticipant = 3;
        ProductionStrategy productionStrategy = new FixedLadderLineProduction();

        // when & then
        assertThatThrownBy(() -> new Ladder(countOfParticipant, productionStrategy))
                .isInstanceOf(LadderLineOverLapException.class);
    }
}
