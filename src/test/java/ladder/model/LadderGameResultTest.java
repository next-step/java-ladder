package ladder.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.ArrayList;
import java.util.List;
import ladder.model.dto.LadderGameInfo;
import ladder.view.LadderGameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 게임 실행 결과 테스트")
public class LadderGameResultTest {

    private Members members;
    private Ladder ladder;
    private LadderGameRewords ladderGameRewords;
    private LadderGameRewords expectedLadderGameRewordsResult;
    private LadderGameInfo ladderGameInfo;

    @BeforeEach
    public void init() {
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(LadderLine.create(LadderBridge.EXIST, LadderBridge.NOT_EXIST, LadderBridge.EXIST));
        ladderLines.add(LadderLine.create(LadderBridge.NOT_EXIST, LadderBridge.EXIST, LadderBridge.NOT_EXIST));
        ladderLines.add(LadderLine.create(LadderBridge.EXIST, LadderBridge.NOT_EXIST, LadderBridge.NOT_EXIST));
        ladderLines.add(LadderLine.create(LadderBridge.NOT_EXIST, LadderBridge.EXIST, LadderBridge.NOT_EXIST));
        ladderLines.add(LadderLine.create(LadderBridge.NOT_EXIST, LadderBridge.EXIST, LadderBridge.NOT_EXIST));
        ladder = Ladder.create(ladderLines);

        members = Members.create("pobi,honux,crong,jk");

        ladderGameRewords = LadderGameRewords.create("꽝,5000,꽝,3000");

        expectedLadderGameRewordsResult = LadderGameRewords.create("꽝,5000,3000,꽝");

        ladderGameInfo = ladderGameInfo.create(members, ladderGameRewords);
    }

    @DisplayName("사다리 게임 생성 테스트")
    @Test
    public void generateLadderGameTests() {
        assertThatCode(() -> LadderGame.create(ladderGameInfo, ladder))
            .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 테스트")
    @Test
    public void executionLadderGameTests() {
        LadderGame ladderGame = LadderGame.create(ladderGameInfo, ladder);
        assertThatCode(ladderGame::start).doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 결과 객체 생성 테스트")
    @Test
    public void generateLadderGameResultTests() {
        assertThatCode(() -> LadderGameResult.create(members, ladderGameRewords))
            .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 결과 테스트")
    @Test
    public void executeLadderGameResultTests() {
        LadderGame ladderGame = LadderGame.create(ladderGameInfo, ladder);
        LadderGameResult result = ladderGame.start();
        LadderGameResult expectedResult = LadderGameResult.create(members, expectedLadderGameRewordsResult);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("사다리 게임 결과 확인 테스트")
    @Test
    public void checkLadderGameResultTests() {
        LadderGameResult ladderGameResult = LadderGameResult.create(members, expectedLadderGameRewordsResult);
        LadderGameMemberResult ladderGameMemberResult = LadderGameMemberResult.create(ladderGameResult);
        String expectAllResult = new StringBuilder()
            .append("pobi : 꽝\n")
            .append("honux : 5000\n")
            .append("crong : 3000\n")
            .append("jk : 꽝\n")
            .toString();

        assertThat(ladderGameMemberResult.get("pobi")).isEqualTo(LadderGameReword.create("꽝"));
        assertThat(ladderGameMemberResult.get("crong")).isEqualTo(LadderGameReword.create("3000"));
        assertThat(ladderGameMemberResult.get("all")).isEqualTo(LadderGameReword.create(expectAllResult));
    }
}