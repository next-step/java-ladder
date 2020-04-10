package ladder;

import ladder.model.*;
import ladder.model.dto.LadderGameMemberResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static ladder.model.LadderBridge.EXIST;
import static ladder.model.LadderBridge.UN_EXIST;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 실행 결과 테스트")
public class LadderGameResultTests {

    private Members members;
    private Ladder ladder;
    private LadderGameRewords ladderGameRewords;
    private LadderGameRewords expectedLadderGameRewordsResult;
    private LadderGameExecutionInfo ladderGameExecutionInfo;

    @BeforeEach
    public void init() {

        ladder = Ladder.newInstance(4, 5);

        members = Members.newInstance("pobi, honux, crong, jk");

        ladderGameRewords = LadderGameRewords.newInstance("꽝,5000,꽝,3000");

        expectedLadderGameRewordsResult = LadderGameRewords.newInstance("꽝,5000,3000,꽝");

        ladderGameExecutionInfo = LadderGameExecutionInfo.newInstance(members, ladderGameRewords);
    }

    @DisplayName("사다리 게임 생성 테스트")
    @Test
    public void generateLadderGameTests() {
        assertThatCode(() -> LadderGame.newInstance(ladderGameExecutionInfo, ladder))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 테스트")
    @Test
    public void executionLadderGameTests() {
        LadderGame ladderGame = LadderGame.newInstance(ladderGameExecutionInfo, ladder);
        assertThatCode(ladderGame::start).doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 결과 객체 생성 테스트")
    @Test
    public void generateLadderGameResultTests() {
        assertThatCode(() -> LadderGameResult.newInstance(members, ladderGameRewords))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 결과 확인 테스트")
    @Test
    public void checkLadderGameResultTests() {
        LadderGameResult ladderGameResult = LadderGameResult.newInstance(members, expectedLadderGameRewordsResult);
        LadderGameMemberResult ladderGameMemberResult = LadderGameMemberResult.newInstance(ladderGameResult);
        String expectAllResult = new StringBuilder()
                .append("pobi : 꽝\n")
                .append("honux : 5000\n")
                .append("crong : 3000\n")
                .append("jk : 꽝\n")
                .toString();

        assertThat(ladderGameMemberResult.get("pobi")).isEqualTo(LadderGameReword.of("꽝"));
        assertThat(ladderGameMemberResult.get("crong")).isEqualTo(LadderGameReword.of("3000"));
        assertThat(ladderGameMemberResult.get("all")).isEqualTo(LadderGameReword.of(expectAllResult));
    }
}
