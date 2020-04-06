package ladder;

import ladder.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 실행 결과 테스트")
public class LadderGameResultTests {

    private LadderGame ladderGame;
    private Members members;
    private LadderPoleResult ladderPoleResult;
    private MemberPolePosition expectLastMemberPolePosition;

    @BeforeEach
    public void init() {
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(LadderLine.newInstance(LadderBridge.EXIST, LadderBridge.UN_EXIST, LadderBridge.EXIST));
        ladderLines.add(LadderLine.newInstance(LadderBridge.UN_EXIST, LadderBridge.EXIST, LadderBridge.UN_EXIST));
        ladderLines.add(LadderLine.newInstance(LadderBridge.EXIST, LadderBridge.UN_EXIST, LadderBridge.UN_EXIST));
        ladderLines.add(LadderLine.newInstance(LadderBridge.UN_EXIST, LadderBridge.EXIST, LadderBridge.UN_EXIST));
        ladderLines.add(LadderLine.newInstance(LadderBridge.UN_EXIST, LadderBridge.EXIST, LadderBridge.UN_EXIST));
        Ladder ladder = Ladder.newInstance(ladderLines);
        ladderGame = LadderGame.newInstance(members, ladder);

        members = Members.newInstance("pobi, honux, crong, jk");

        ladderPoleResult = LadderPoleResult.newInstance("꽝,5000,꽝,3000");

        expectLastMemberPolePosition = MemberPolePosition.newInstance("pobi, jk, crong, honux");

    }

    @DisplayName("사다리 게임 실행 결과 객체 생성 테스트")
    @Test
    public void generateLadderGameResultTests() {
        assertThatCode(() -> LadderGameResult.newInstance(expectLastMemberPolePosition, ladderPoleResult))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 결과 테스트")
    @Test
    public void executeLadderGameResultTests() {
        assertThat(ladderGame.start()).isEqualsTo(LadderGameResult.newInstance(expectLastMemberPolePosition, ladderPoleResult));
    }

    @DisplayName("사다리 게임 결과 확인 테스트")
    @Test
    public void checkLadderGameResultTests() {
        LadderGameResult ladderGameResult = LadderGameResult.newInstance(expectLastMemberPolePosition, ladderPoleResult);
        String expectAllResult = new StringBuilder()
                .append("pobi : 꽝\n")
                .append("honux : 5000\n")
                .append("crong : 꽝\n")
                .append("jk : 3000\n")
                .toString();

        assertThat(ladderGameResult.get("pobi")).isEqualsTo("꽝");
        assertThat(ladderGameResult.get("jk")).isEqualsTo("5000");
        assertThat(ladderGameResult.get("all")).isEqualsTo(expectAllResult);

    }
}
