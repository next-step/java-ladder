package nextstep.ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LadderPrinterTest {

    @Test
    @DisplayName("사다리가 주여졌을 때, 문자열로 반환한다.")
    void 사다리_문자열_출력() {
        List<Point> points = Arrays.asList(
                new Point(false, true),
                new Point(true, false),
                new Point(false, false));
        Line line = new Line(points);
        LadderPrinter printer = new LadderPrinter(new Ladder(line));
        Assertions.assertThat(printer.printLadder()).isEqualTo("     |-----|     |\n");
    }
}
