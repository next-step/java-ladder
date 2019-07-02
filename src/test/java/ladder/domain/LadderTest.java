package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    void 사다리만들기() {
        Ladder ladder = new Ladder(4, "5");
        List<Line> lines = ladder.getLines();
        lines.stream().forEach(t -> {
            t.getPoints().stream().forEach(j-> System.out.print(j+"   "));
            System.out.println();
        });
    }

    @Test
    void 유효하지않은사다리높이_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Ladder ladder = new Ladder(4, "0");
            ladder = new Ladder(4, "a");
            ladder = new Ladder(4, "");
            ladder = new Ladder(4, "-1");
        });
    }
}
