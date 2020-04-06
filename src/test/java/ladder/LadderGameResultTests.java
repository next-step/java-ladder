package ladder;

import ladder.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("사다리 게임 실행 결과 테스트")
public class LadderGameResultTests {

    private LadderGame ladderGame;
    private Members members;
    private LadderGameRewords ladderGameRewords;
    private LadderGameRewords ladderGameRewordsResult;


    @BeforeEach
    public void init() {
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(LadderLine.newInstance(LadderBridge.EXIST, LadderBridge.UN_EXIST, LadderBridge.EXIST));
        ladderLines.add(LadderLine.newInstance(LadderBridge.UN_EXIST, LadderBridge.EXIST, LadderBridge.UN_EXIST));
        ladderLines.add(LadderLine.newInstance(LadderBridge.EXIST, LadderBridge.UN_EXIST, LadderBridge.UN_EXIST));
        ladderLines.add(LadderLine.newInstance(LadderBridge.UN_EXIST, LadderBridge.EXIST, LadderBridge.UN_EXIST));
        ladderLines.add(LadderLine.newInstance(LadderBridge.UN_EXIST, LadderBridge.EXIST, LadderBridge.UN_EXIST));
        LadderLines lines = LadderLines.newInstance(ladderLines);

        members = Members.newInstance("pobi, honux, crong, jk");

        ladderGameRewords = LadderGameRewords.newInstance("꽝,5000,꽝,3000");

        ladderGameRewordsResult = LadderGameRewords.newInstance("꽝,3000,꽝,5000");

        Ladder ladder = Ladder.newInstance(lines, ladderGameRewords);

        ladderGame = LadderGame.newInstance(members, ladder);


    }

    @DisplayName("사다리 게임 실행 결과 객체 생성 테스트")
    @Test
    public void generateLadderGameResultTests() {
        assertThatCode(() -> LadderGameResult.newInstance(members, ladderGameRewords))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 실행 결과 테스트")
    @Test
    public void executeLadderGameResultTests() {
        assertThat(ladderGame.start()).isEqualTo(LadderGameResult.newInstance(members, ladderGameRewords));
    }

    @DisplayName("사다리 게임 결과 확인 테스트")
    @Test
    public void checkLadderGameResultTests() {
        LadderGameResult ladderGameResult = LadderGameResult.newInstance(members, ladderGameRewordsResult);
        String expectAllResult = new StringBuilder()
                .append("pobi : 꽝\n")
                .append("honux : 5000\n")
                .append("crong : 꽝\n")
                .append("jk : 3000\n")
                .toString();

        assertThat(ladderGameResult.get("pobi")).isEqualTo("꽝");
        assertThat(ladderGameResult.get("jk")).isEqualTo("5000");
        assertThat(ladderGameResult.get("all")).isEqualTo(expectAllResult);

    }
}
