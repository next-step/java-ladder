package ladder;

import ladder.model.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 테스트")
public class LadderGameTests {

    @DisplayName("사다리 게임 생성 테스트")
    @Test
    public void generateLadderGameTests() {
        Members members = Members.newInstance(new String[]{"a", "b", "c"});
        LadderGameRewords ladderGameRewords = LadderGameRewords.newInstance("꽝,5000,꽝,3000");

        assertThatCode(() -> LadderGame.newInstance(members, Ladder.newInstance(members.count(), LadderHeight.newInstance(4), ladderGameRewords)))
                .doesNotThrowAnyException();
        assertThatCode(() -> LadderGame.newInstance(members, Ladder.newInstance(3, 4, "꽝,5000,꽝,3000")))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 테스트")
    @Test
    public void executionLadderGameTests() {
        Members members = Members.newInstance(new String[]{"a", "b", "c"});
        Ladder ladder = Ladder.newInstance(3, 4, "꽝,5000,꽝,3000");

        LadderGame ladderGame = LadderGame.newInstance(members, ladder);
        assertThatCode(ladderGame::start).doesNotThrowAnyException();
    }
}
