package ladder;

import ladder.model.LadderPole;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("사다리 세로라인 LadderPole 테스트")
public class LadderPoleTests {

    @DisplayName("생성 테스트")
    @Test
    public void generateLadderPoleTest() {
        assertThatCode(() -> LadderPole.of(2)).doesNotThrowAnyException();
    }

    @DisplayName("생성 비정상 테스트")
    @Test
    public void generateAbnormalLadderPoleTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LadderPole.of(-1))
                .withMessageContaining("Ladder pole must be greater than zero.");
    }
}
