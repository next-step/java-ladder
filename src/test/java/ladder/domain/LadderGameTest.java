package ladder.domain;

import ladder.fixtures.LadderFixtures;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static ladder.view.InputView.NAME_REGEX;
import static ladder.view.ResultView.RESULT_REGEX;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGameTest {

    @Test
    public void 실행결과_개수가_참여자수와_동일한지() {
        LadderGame controller = new LadderGame();
        assertThatThrownBy(() -> controller.checkValidationOfResultsNumber(4, 5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("실행 결과의 갯수는 참여하는 사람의 수와 동일해야 합니다.");
    }

    @Test
    public void 실행결과_테스트_1명() {
        Ladder ladder = LadderFixtures.createLadder();
        Names names = Names.of("pobi,honux,crong,jk".split(NAME_REGEX));
        Results results = Results.of("꽝,3000,꽝,5000".split(RESULT_REGEX));

        LadderGame controller = new LadderGame(names, results);

        assertAll(() -> assertThat(controller.getExecutionResult("pobi", ladder)).isEqualTo("꽝"),
                () -> assertThat(controller.getExecutionResult("honux", ladder)).isEqualTo("5000"),
                () -> assertThat(controller.getExecutionResult("crong", ladder)).isEqualTo("꽝"),
                () -> assertThat(controller.getExecutionResult("jk", ladder)).isEqualTo("3000"));
    }

    @Test
    public void 실행결과_테스트_전체() {
        Ladder ladder = LadderFixtures.createLadder();
        Names names = Names.of("pobi,honux,crong,jk".split(NAME_REGEX));
        Results results = Results.of("꽝,3000,꽝,5000".split(RESULT_REGEX));

        LadderGame controller = new LadderGame(names, results);
        Map<Name, String> ladderResult = controller.getExecutionResultAll(ladder);
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

        LadderGame controller = new LadderGame(names, results);
        Map<Name, String> ladderResult = controller.getExecutionResultAll(ladder);
        assertAll(() -> assertThat(ladderResult.get(new Name("pobi"))).isEqualTo("꽝"),
                () -> assertThat(ladderResult.get(new Name("honux"))).isEqualTo("3000"),
                () -> assertThat(ladderResult.get(new Name("crong"))).isEqualTo("꽝"),
                () -> assertThat(ladderResult.get(new Name("jk"))).isEqualTo("5000"));
    }
}