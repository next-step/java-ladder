package nextstep.ladder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {
    private Lines lines;

    @BeforeEach
    void setUp() {
//        lines = new Lines(6, 5);
        lines = new Lines(
                Arrays.asList(
                        new Line(new Points(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, false), new Point(false, false), new Point(false, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, false), new Point(false, true), new Point(true, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false), new Point(false, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, false), new Point(false, true), new Point(true, false), new Point(false, true), new Point(true, false)))),
                        new Line(new Points(Arrays.asList(new Point(false, false), new Point(false, false), new Point(false, false), new Point(false, true), new Point(true, false))))
                )
        );
    }

    @Test
    @DisplayName("사다리 전체 출력 확인")
    void check() {
        for (Line line : lines.getValues()) {
            System.out.println(line.toString());
            System.out.println(line.getResultIndexs());
        }
        System.out.println(lines.toString("-----", "     "));
    }

    @Test
    @DisplayName("사다리 라인 사이즈 확인")
    void size() {
        assertThat(lines.getValues()).hasSize(6);
    }

    @Test
    void getFinalResultIndexs() {
        System.out.println("테스트");
        System.out.println(lines.getFinalResultIndexs(5));
    }
}
