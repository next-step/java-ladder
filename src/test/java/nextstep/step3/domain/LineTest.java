package nextstep.step3.domain;

import nextstep.step3.strategy.TestDrawLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Line 테스트")
class LineTest {

    private int userCount = 4;
    private List<Boolean> points1 = Arrays.asList(true, false, true);

    private Line line;

    @DisplayName("생성자를 통한 라인 생성 확인")
    @Test
    void Line() {
        line = new Line(userCount, new TestDrawLineStrategy(points1));

        assertThat(line.getPoints().size()).isEqualTo(3);
        assertThat(line.getPoints().get(0)).isTrue();
        assertThat(line.getPoints().get(1)).isFalse();
        assertThat(line.getPoints().get(2)).isTrue();
    }
}
