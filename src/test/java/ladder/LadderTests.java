package ladder;

import ladder.model.Ladder;
import ladder.model.LadderHeight;
import ladder.model.PoleCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 테스트")
public class LadderTests {

    @DisplayName("사다리 생성 테스트")
    @Test
    public void generateLadderTests() {
        assertThatCode(() -> Ladder.newInstance(4, 5)).doesNotThrowAnyException();
        assertThatCode(() -> Ladder.newInstance(PoleCount.of(5), LadderHeight.newInstance(3))).doesNotThrowAnyException();
    }
}
