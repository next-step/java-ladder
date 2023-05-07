package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    private Lines drawLines(String names) {
        List<String> newNames = List.of(names.split(","));
        LadderInputs participants = LadderInputs.from(newNames);

        return Lines.drawLines(participants, (index, previous) -> index != 0 && !previous);
    }

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
        Lines newLines = drawLines("a,b,c");

        Lines resultLines = new Lines(List.of(new Line(false), new Line(true), new Line(false)));

        assertThat(newLines.getLines())
                .usingRecursiveComparison()
                .isEqualTo(resultLines.getLines());
    }

    @Test
    @DisplayName("라인 결과 테스트 - 1개")
    void lineResultOnlyOneTest() {
        Lines newLines = drawLines("a");

        Results results = newLines.followLine();

        System.out.println(results);

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(List.of(new Result(0))));
    }

    @Test
    @DisplayName("라인 결과 테스트 - 2개, 라인 없음")
    void noLineResultTwoTest() {
        List<String> names = List.of("a,b".split(","));
        LadderInputs participants = LadderInputs.from(names);
        Lines newLines = Lines.drawLines(participants, (index, previous) -> false);

        Results results = newLines.followLine();

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(List.of(new Result(0), new Result(1))));
    }

    @Test
    @DisplayName("라인 결과 테스트 - 2개, 라인있음")
    void hasLineResultTwoTest() {
        Lines newLines = drawLines("a,b");

        Results results = newLines.followLine();

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(List.of(new Result(1), new Result(0))));
    }

    @Test
    @DisplayName("라인 결과 테스트 - 여러개")
    void lineResultTest() {
        Lines newLines = drawLines(("a,b,c"));
        Results results = newLines.followLine();

        assertThat(results)
                .usingRecursiveComparison()
                .isEqualTo(new Results(List.of(
                        new Result(1),
                        new Result(0),
                        new Result(2)
                )));


        Lines newLines2 = drawLines(("a,b,c,d,e"));
        Results results2 = newLines2.followLine();

        assertThat(results2)
                .usingRecursiveComparison()
                .isEqualTo(new Results(List.of(
                        new Result(1),
                        new Result(0),
                        new Result(3),
                        new Result(2),
                        new Result(4)
                )));
    }

}
