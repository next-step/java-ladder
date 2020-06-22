package nextstep.step3.domain;

import nextstep.step3.domain.strategy.TestDrawLineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DirectionChecker 테스트")
class DirectionCheckerTest {
    private DirectionChecker directionChecker;
    private List<Line> lines;
    // 요구사항 실행결과와 동일한 사다리 구성
    private List<Boolean> points1 = Arrays.asList(true, false, true);
    private List<Boolean> points2 = Arrays.asList(false, true, false);
    private List<Boolean> points3 = Arrays.asList(true, false, false);
    private List<Boolean> points4 = Arrays.asList(false, true, false);
    private List<Boolean> points5 = Arrays.asList(true, false, true);

    @BeforeEach
    void setUp() {
        lines = new ArrayList<>();
        lines.add(new Line(4, new TestDrawLineStrategy(points1)));
        lines.add(new Line(4, new TestDrawLineStrategy(points2)));
        lines.add(new Line(4, new TestDrawLineStrategy(points3)));
        lines.add(new Line(4, new TestDrawLineStrategy(points4)));
        lines.add(new Line(4, new TestDrawLineStrategy(points5)));

        directionChecker = new DirectionChecker(lines);
    }


    @DisplayName("사다리 진행 결과 체크")
    @Test
    void getResult() {
        List<Integer> result = Arrays.asList(0, 3, 2, 1);
        assertThat(directionChecker.getResult()).isEqualTo(result);
    }
}
