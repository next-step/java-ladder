package nextstep.ladder.domain;

import nextstep.ladder.domain.util.RandomStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("사다리 생성 테스트")
    void initLadderTest() {
        List<String> names = List.of("a,b,c,".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Ladder ladder = Ladder.from(new Heights(5), participants, new RandomStrategy());

        assertThat(ladder.getLadderHeights())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("사다리 결과 테스트 - 1줄")
    void oneLineResultsTest() {
        Step step1 = Step.firstStep(true);
        Step step2 = step1.lastStep();
        Line line = new Line(List.of(step1, step2));

        Ladder ladder = new Ladder(List.of(line));
        Results results = ladder.move();

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 1);
        expected.put(1, 0);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("사다리 결과 테스트 - 2줄")
    void twoLineResultsTest() {
        Step step1 = Step.firstStep(true);
        Step step2 = step1.lastStep();

        Step step11 = Step.firstStep(true);
        Step step12 = step11.lastStep();

        Line line1 = new Line(List.of(step1, step2));
        Line line2 = new Line(List.of(step11, step12));

        Ladder ladder = new Ladder(List.of(line1, line2));
        Results results = ladder.move();

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 1);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }
}
