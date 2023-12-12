package nextstep.ladder.domain;

import nextstep.ladder.domain.strategy.RandomLadderPoint;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    @Test
    @DisplayName("참가자 수와 결과 수가 일치하지 않으면 예외가 발생한다")
    void validateLadderResults_exception() {
        Names names = new Names(List.of(new Name("a")));
        List<LadderResult> inputLadderResults = List.of(new LadderResult("꽝"), new LadderResult("1000"));
        Lines lines = new Lines();
        lines.initialize(1, new Height(1), new RandomLadderPoint());
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new LadderGame(names, lines, inputLadderResults);
        });
    }
}