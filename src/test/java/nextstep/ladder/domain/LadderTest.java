package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void createLadderTest() {
        List<String> names = List.of("a,b,c".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Ladder ladder = Ladder.from(new Heights(5), participants, (index, previous) -> true);

        assertThat(ladder.getLadderHeights())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 결과 테스트 - 1줄")
    void oneLineResultsTest() {
        LadderInputs participants = LadderInputs.from(List.of("a,b".split(",")));
        Ladder ladder = Ladder.from(new Heights(1), participants, (index, previous) -> index != 0 && !previous);

        Results previousResults = Results.init(participants);
        Results results = ladder.getResults(previousResults);

        Map<Integer, Result> expected = new HashMap<>();
        expected.put(0, new Result(1));
        expected.put(1, new Result(0));

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("사다리 결과 테스트 - 2줄")
    void twoLineResultsTest() {
        LadderInputs participants = LadderInputs.from(List.of("a,b".split(",")));
        Ladder ladder = Ladder.from(new Heights(2), participants, (index, previous) -> index != 0 && !previous);

        Results previousResults = Results.init(participants);
        Results results = ladder.getResults(previousResults);

        Map<Integer, Result> expected = new HashMap<>();
        expected.put(0, new Result(0));
        expected.put(1, new Result(1));

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

}
