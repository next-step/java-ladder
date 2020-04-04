package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 테스트")
public class LadderGameTests {

    @DisplayName("사다리 게임 생성 테스트")
    @Test
    public void generateLadderTests() {
        assertThatCode(() -> LadderGame.newInstance(Members.newInstance(new String[]{"a", "b", "c"}), LadderHeight.newInstance(4)))
                .doesNotThrowAnyException();
    }
}
