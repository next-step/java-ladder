package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class ResultsTest {

    @Test
    @DisplayName("첫번째 라인 이동 테스트")
    void firstMovePositionTest() {
        Step step1 = Step.firstStep(true);
        Step step2 = step1.lastStep();

        Line line = new Line(List.of(step1, step2));
        Results results = Results.firstMove(line);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 1);
        expected.put(1, 0);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("첫번째 라인 이동 안함 테스트")
    void firstDontMovePositionTest() {
        Step step1 = Step.firstStep(false);
        Step step2 = step1.lastStep();

        Line line = new Line(List.of(step1, step2));
        Results results = Results.firstMove(line);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 1);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("첫번째 라인 여러 값일 때 테스트")
    void firstManyValueTest() {
        Step step1 = Step.firstStep(true);
        Step step2 = step1.nextStep(false);
        Step step3 = step2.nextStep(true);
        Step step4 = step3.nextStep(false);
        Step step5 = step4.nextStep(false);
        Step step6 = step5.lastStep();

        Line line = new Line(List.of(step1, step2, step3, step4, step5, step6));
        Results results = Results.firstMove(line);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 1);
        expected.put(1, 0);
        expected.put(2, 3);
        expected.put(3, 2);
        expected.put(4, 4);
        expected.put(5, 5);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("두번째줄 라인 이동 테스트")
    void overSecondMovePositionTest() {
        Step step1 = Step.firstStep(true);
        Step step2 = step1.lastStep();

        Line line = new Line(List.of(step1, step2));
        Results results = Results.firstMove(line).nextMove(line);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 0);
        expected.put(1, 1);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("두번째줄 3개값 라인 이동 테스트")
    void overSecondMoveTriplePositionTest() {
        Step step1 = Step.firstStep(true);
        Step step2 = step1.nextStep(false);
        Step step3 = step2.lastStep();

        Step step11 = Step.firstStep(false);
        Step step12 = step11.nextStep(true);
        Step step13 = step12.lastStep();


        Line line1 = new Line(List.of(step1, step2, step3));
        Line line2 = new Line(List.of(step11, step12, step13));
        Results results1 = Results.firstMove(line1);
        Results results = results1.nextMove(line2);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 2);
        expected.put(1, 0);
        expected.put(2, 1);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("두번째줄 여러값 라인 이동 테스트")
    void overSecondMoveManyPositionTest() {
        Step step1 = Step.firstStep(true);
        Step step2 = step1.nextStep(false);
        Step step3 = step2.nextStep(true);
        Step step4 = step3.nextStep(false);
        Step step5 = step4.nextStep(false);
        Step step6 = step5.lastStep();

        Step step11 = Step.firstStep(false);
        Step step12 = step11.nextStep(true);
        Step step13 = step12.nextStep(false);
        Step step14 = step13.nextStep(true);
        Step step15 = step14.nextStep(false);
        Step step16 = step15.lastStep();

        Line line1 = new Line(List.of(step1, step2, step3, step4, step5, step6));
        Line line2 = new Line(List.of(step11, step12, step13, step14, step15, step16));
        Results results1 = Results.firstMove(line1);
        Results results = results1.nextMove(line2);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(0, 2);
        expected.put(1, 0);
        expected.put(2, 4);
        expected.put(3, 1);
        expected.put(4, 3);
        expected.put(5, 5);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

}
