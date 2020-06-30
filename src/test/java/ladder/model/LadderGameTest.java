package ladder.model;

import ladder.model.dto.LadderGameInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 테스트")
public class LadderGameTest {

    private Ladder ladder;
    private LadderGameInfo ladderGameInfo;

    @BeforeEach
    public void init() {
        ladder = Ladder.create(5, 5);
        ladderGameInfo = LadderGameInfo.create(Members.create("pobi,yong,crong,taeg"), LadderGameRewords.create("5000,꽝,꽝,1000"));
    }

    @DisplayName("사다리 게임 생성 테스트")
    @Test
    public void createLadderTest() {
        assertThatCode(() -> LadderGame.create(ladderGameInfo, ladder))
                .doesNotThrowAnyException();
    }
}