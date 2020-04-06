package ladder;

import ladder.model.LadderGame;
import ladder.model.LadderHeight;
import ladder.model.Members;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 테스트")
public class LadderGameTests {

    @DisplayName("사다리 게임 생성 테스트")
    @Test
    public void generateLadderGameTests() {
        assertThatCode(() -> LadderGame.newInstance(Members.newInstance(new String[]{"a", "b", "c"}), LadderHeight.newInstance(4)))
                .doesNotThrowAnyException();
        assertThatCode(() -> LadderGame.newInstance(new String[]{"a", "b", "c"}, 4))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 테스트")
    @Test
    public void executionLadderGameTests() {
        LadderGame ladderGame = LadderGame.newInstance(new String[]{"a", "b", "c"}, 4);
        assertThatCode(() -> ladderGame.start()).doesNotThrowAnyException();
    }
}
