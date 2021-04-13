package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("여러 라인을 만드는 테스트")
    void multiLineTest() {

        Lines lines = new Lines(new Height(3),3);
        assertThat(lines.lines().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("사다리 게임 결과 테스트")
    void resultLadderGame() {
        Lines lines = new Lines(createLine());
        assertThat(lines.eachPositionResult(0)).isEqualTo(2);
        assertThat(lines.eachPositionResult(1)).isEqualTo(0);
        assertThat(lines.eachPositionResult(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("한 사람의 결과 반환 테스트")
    void onePersonResultTest() {
        Lines lines = new Lines(createLine());
        ExecutionResults results = new ExecutionResults(Arrays.asList(new ExecutionResult("꽝"), new ExecutionResult("5000"), new ExecutionResult("3000")));
        assertThat(lines.eachPositionResult2(0, results)).isEqualTo(results.oneResult(2));
        assertThat(lines.eachPositionResult2(1, results)).isEqualTo(results.oneResult(0));
        assertThat(lines.eachPositionResult2(2, results)).isEqualTo(results.oneResult(1));
    }

    @Test
    @DisplayName("모든 사람의 결과 반환 테스트")
    void allPersonResultTest() {
        Lines lines = new Lines(createLine());
        Persons persons = new Persons(Arrays.asList(new Person("aa"), new Person("bb"), new Person("cc")));
        ExecutionResults results = new ExecutionResults(Arrays.asList(new ExecutionResult("꽝"), new ExecutionResult("5000"), new ExecutionResult("3000")));
        Result result = lines.result(persons, results);
        assertThat(result.get(new Person("aa"))).isEqualTo(new ExecutionResult("3000"));
        assertThat(lines.eachPositionResult2(0, results)).isEqualTo(results.oneResult(2));
    }

    public List<Line> createLine() {
        List<Line> lines = new ArrayList<>();
        lines.add(new Line(Arrays.asList(Point.first(true), Point.first(true).next(false), Point.first(true).next(false).last())));
        lines.add(new Line(Arrays.asList(Point.first(false), Point.first(false).next(false), Point.first(false).next(false).last())));
        lines.add(new Line(Arrays.asList(Point.first(false), Point.first(false).next(true), Point.first(false).next(true).last())));
        return lines;
    }

}
