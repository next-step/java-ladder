package ladder.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    public Line line1;
    public Line line2;
    public Line line3;
    public Line line4;

    @BeforeEach
    public void setLine() {
        this.line1 = new Line();
        line1.calculatorLine(4);
        this.line2 = new Line();
        line2.calculatorLine(4);
        this.line3 = new Line();
        line3.calculatorLine(4);
        this.line4 = new Line();
        line4.calculatorLine(4);
    }

    @Test
    @DisplayName("라인 값에 중복으로 true가 있는지 체크")
    void connectLine() {
        List<Boolean> line = line1.getLine();
        boolean isConsecutiveTrue = IntStream.range(0, line.size())
                .filter(i -> line.get(i))
                .allMatch(i -> i == 0 || line.get(i - 1));

        assertThat(isConsecutiveTrue).isFalse();
    }
}

