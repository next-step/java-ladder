package ladder.domain;

import ladder.fixtures.LadderFixtures;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static ladder.domain.LadderGame.ERR_MSG_CANDIDATE_NAME;
import static ladder.domain.LadderGame.ERR_MSG_RESULTS_NUMBER;
import static ladder.view.InputView.NAME_REGEX;
import static ladder.view.ResultView.RESULT_REGEX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderGameTest {
    @Test
    public void 실행결과_개수가_참여자수와_동일한지() {
        Names names = Names.of("pobi,honux,crong,jk".split(NAME_REGEX));
        Results results = Results.of("꽝,3000,꽝".split(RESULT_REGEX));

        assertThatThrownBy(() -> new LadderGame(names, results))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERR_MSG_RESULTS_NUMBER);
    }

    @Test
    public void 실행결과_보고싶은_참가자이름() {
        Names names = Names.of("pobi,honux,crong,jk".split(NAME_REGEX));
        Results results = Results.of("꽝,3000,꽝,5000".split(RESULT_REGEX));

        LadderGame ladderGame = new LadderGame(names, results);
        assertThatThrownBy(() -> ladderGame.validateCandidateName("pobbi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERR_MSG_CANDIDATE_NAME);
    }
    @Test
    public void 실행결과_테스트_1명() {
        Ladder ladder = LadderFixtures.createLadder();
        Names names = Names.of("pobi,honux,crong,jk".split(NAME_REGEX));
        Results results = Results.of("꽝,3000,꽝,5000".split(RESULT_REGEX));

        LadderGame ladderGame = new LadderGame(names, results);

        assertAll(() -> assertThat(ladderGame.getExecutionResult("pobi", ladder)).isEqualTo("꽝"),
                () -> assertThat(ladderGame.getExecutionResult("honux", ladder)).isEqualTo("5000"),
                () -> assertThat(ladderGame.getExecutionResult("crong", ladder)).isEqualTo("꽝"),
                () -> assertThat(ladderGame.getExecutionResult("jk", ladder)).isEqualTo("3000"));
    }

    @Test
    public void 실행결과_테스트_전체() {
        Ladder ladder = LadderFixtures.createLadder();
        Names names = Names.of("pobi,honux,crong,jk".split(NAME_REGEX));
        Results results = Results.of("꽝,3000,꽝,5000".split(RESULT_REGEX));

        LadderGame ladderGame = new LadderGame(names, results);
        Map<Name, String> ladderResult = ladderGame.getExecutionResultAll(ladder);
        assertAll(() -> assertThat(ladderResult.get(new Name("pobi"))).isEqualTo("꽝"),
                () -> assertThat(ladderResult.get(new Name("honux"))).isEqualTo("5000"),
                () -> assertThat(ladderResult.get(new Name("crong"))).isEqualTo("꽝"),
                () -> assertThat(ladderResult.get(new Name("jk"))).isEqualTo("3000"));
    }

    @Test
    public void 실행결과_테스트_전체2() {
        Ladder ladder = LadderFixtures.createLadder2();
        Names names = Names.of("pobi,honux,crong,jk".split(NAME_REGEX));
        Results results = Results.of("꽝,3000,꽝,5000".split(RESULT_REGEX));

        LadderGame ladderGame = new LadderGame(names, results);
        Map<Name, String> ladderResult = ladderGame.getExecutionResultAll(ladder);
        assertAll(() -> assertThat(ladderResult.get(new Name("pobi"))).isEqualTo("꽝"),
                () -> assertThat(ladderResult.get(new Name("honux"))).isEqualTo("5000"),
                () -> assertThat(ladderResult.get(new Name("crong"))).isEqualTo("꽝"),
                () -> assertThat(ladderResult.get(new Name("jk"))).isEqualTo("3000"));
    }
}