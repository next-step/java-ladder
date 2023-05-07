package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("가로 줄 생성 테스트")
    void createLinesTest() {
        List<String> names = List.of("a,b,c,d,e".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> true);

        assertThat(newLines.numberOfLines())
                .isEqualTo(names.size());
    }

    @Test
    @DisplayName("직전 라인이 그려졌을 때 다음 라인 그리지 않는 테스트")
    void trueAfterFalseTest() {
        List<String> names = List.of("a,b,c".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> index != 0 && !previous);

        Lines resultLines = new Lines(List.of(new Line(false), new Line(true), new Line(false)));

        assertThat(newLines.getLines())
                .usingRecursiveComparison()
                .isEqualTo(resultLines.getLines());
    }

    @Test
    @DisplayName("라인 결과 테스트 - 1개")
    void lineResultOnlyOneTest() {
        List<String> names = List.of("a".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> index != 0 && !previous);
        Results previousResults = Results.init(participants);

        Results results = newLines.followLine(previousResults);

        Map<Integer, Result> expected = new HashMap<>();
        expected.put(0, new Result(0));

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("라인 결과 테스트 - 2개 라인 없음")
    void noLineResultTwoTest() {
        List<String> names = List.of("a,b".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> false);
        Results previousResults = Results.init(participants);

        Results results = newLines.followLine(previousResults);

        Map<Integer, Result> expected = new HashMap<>();
        expected.put(0, new Result(0));
        expected.put(1, new Result(1));

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("라인 결과 테스트 - 2개 라인 있음")
    void hasLineResultTwoTest() {
        List<String> names = List.of("a,b".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> index != 0 && !previous);
        Results previousResults = Results.init(participants);

        Results results = newLines.followLine(previousResults);

        Map<Integer, Result> expected = new HashMap<>();
        expected.put(0, new Result(1));
        expected.put(1, new Result(0));

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }

    @Test
    @DisplayName("라인 결과 테스트 - 여러개")
    void lineResultTest() {
        List<String> names = List.of("a,b,c".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> index != 0 && !previous);
        Results previousResults = Results.init(participants);

        Results results = newLines.followLine(previousResults);

        Map<Integer, Result> expected = new HashMap<>();
        expected.put(0, new Result(1));
        expected.put(1, new Result(0));
        expected.put(2, new Result(2));

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));


        List<String> names2 = List.of("a,b,c,d,e".split(","));
        LadderInputs participants2 = LadderInputs.from(names2);
        Lines newLines2 = Lines.drawLines(participants2, (index, previous) -> index != 0 && !previous);
        Results previousResults2 = Results.init(participants2);

        Results results2 = newLines2.followLine(previousResults2);
        Map<Integer, Result> expected2 = new HashMap<>();
        expected2.put(0, new Result(1));
        expected2.put(1, new Result(0));
        expected2.put(2, new Result(3));
        expected2.put(3, new Result(2));
        expected2.put(4, new Result(4));

        assertThat(results2)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected2));
    }

    @Test
    @DisplayName("2번째 줄 이상일 때 테스트")
    void hasLineResultSecondLineTest() {
        List<String> names = List.of("a,b".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> index != 0 && !previous);

        Map<Integer, Result> secondLine = new HashMap<>();
        secondLine.put(0, new Result(1));
        secondLine.put(1, new Result(0));
        Results previousResults = new Results(secondLine);

        Results results = newLines.followLine(previousResults);

        Map<Integer, Result> expected = new HashMap<>();
        expected.put(0, new Result(0));
        expected.put(1, new Result(1));

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(expected));
    }
}
