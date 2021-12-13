package nextstep.ladder.model;

import nextstep.ladder.factory.LineFactory;
import nextstep.ladder.generator.LineRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    @DisplayName("이전 다리가 있을 경우, 다음 다리는 무조건 없음 ")
    void beforeTrueThenFalse() {
        LineRandomGenerator generator = new LineRandomGenerator();
        Line line = LineFactory.of(Boolean.TRUE, 4, generator);

        String[] split = line.toString().split("\\|");
        assertThat(split[2]).isEqualTo(Line.BLANK_LINE);
    }
}