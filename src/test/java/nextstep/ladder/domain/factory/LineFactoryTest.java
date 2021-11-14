package nextstep.ladder.domain.factory;

import nextstep.ladder.doamin.Line;
import nextstep.ladder.doamin.fcatory.LineFactory;
import nextstep.ladder.strategy.RandomLineStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineFactoryTest {

    LineFactory lineFactory;

    @BeforeEach
    void setup() {
        lineFactory = new LineFactory();
    }

    @Test
    @DisplayName("사다리 높이 만큼 라인 수 생성 검증")
    void createLines() {
        int height = 4;
        List<Line> lines = lineFactory.createLines(new RandomLineStrategy(), 4, height);

        assertThat(lines.size()).isEqualTo(height);
    }
}
