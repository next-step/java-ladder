package nextstep.ladder.domain;

import nextstep.ladder.strategy.LineStrategy;
import nextstep.ladder.strategy.TrueLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    public static Line LINE_TRUE_FALSE_TRUE = new Line(List.of(true, false, true));
    public static Line LINE_TRUE_TRUE_FALSE = new Line(List.of(true, true, false));
    public static Line LINE_TRUE_TRUE_TRUE = new Line(List.of(true, true, true));
    public static Line LINE_FALSE_FALSE_TRUE = new Line(List.of(false, false, true));
    public static Line LINE_FALSE_TRUE_FALSE = new Line(List.of(false, true, false));
    public static Line LINE_FALSE_FALSE_FALSE = new Line(List.of(false, false, false));

    @Test
    @DisplayName("랜덤 결과가 true로만 나오게 하여 가로가 겹치지 않는 좌표 생성")
    void generateLine() {
        LineStrategy lineStrategy = new TrueLineStrategy();
        Line line = new Line(10, lineStrategy);

        assertThat(line.getPoints()).hasSize(9);
        for (int i = 0; i < line.getLine().size(); i++) {
            assertThat(line.getLine(i)).isEqualTo(i % 2 == 0);
        }
    }
}
