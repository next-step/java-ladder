package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    @DisplayName("각 포지션에 대한 마지막 포지션 값 테스트")
    void onePositionResultTest() {
        Lines lines = new Lines(createLine());
        ExecutionResults results = new ExecutionResults(Arrays.asList(new ExecutionResult("꽝"), new ExecutionResult("5000"), new ExecutionResult("3000")));
        Result result = new Result(lines, results);


        assertThat(result.getMoveResult()).isEqualTo(Arrays.asList(2,0,1));
    }

    @Test
    @DisplayName("포지션이 이동한 결과값에 따른 실행결과 조회 테스트")
    void getExecutionResultListTest() {
        Lines lines = new Lines(createLine());
        ExecutionResults results = new ExecutionResults(Arrays.asList(new ExecutionResult("꽝"), new ExecutionResult("5000"), new ExecutionResult("3000")));
        Result result = new Result(lines, results);

        assertThat(result.getExecutionResult()).isEqualTo(new ExecutionResults(Arrays.asList(new ExecutionResult("3000"), new ExecutionResult("꽝"), new ExecutionResult("5000"))));
    }

    public List<Line> createLine() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(Point.first(true), Point.first(true).next(false), Point.first(true).next(false).last())));
        lines.add(new Line(Arrays.asList(Point.first(false), Point.first(false).next(false), Point.first(false).next(false).last())));
        lines.add(new Line(Arrays.asList(Point.first(false), Point.first(false).next(true), Point.first(false).next(true).last())));
        return lines;
    }
}
