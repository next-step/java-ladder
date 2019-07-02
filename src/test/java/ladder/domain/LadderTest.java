package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

public class LadderTest {
    @Test
    void 사다리만들기() {
        Ladder ladder = new Ladder(4, 5);
        List<Line> lines = ladder.getLines();
        lines.stream().forEach(t -> {
            t.getPoints().stream().forEach(j-> System.out.print(j+"   "));
            System.out.println();
        });
    }
}
