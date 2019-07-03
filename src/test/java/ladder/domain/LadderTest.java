package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LadderTest {
    @Test
    void 사다리구성하는point들의value출력() {
        Ladder ladder = Ladder.newLadder(4, "5");
        List<Line> lines = ladder.getLines();
        lines.stream().forEach(t -> {
            t.getPoints().stream().forEach(j-> System.out.print(j+"   "));
            System.out.println();
        });
    }

    @Test
    void 유효하지않은사다리높이입력값_IllegalArgumentException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Ladder ladder = Ladder.newLadder(4, "0");
            ladder = Ladder.newLadder(4, "a");
            ladder = Ladder.newLadder(4, "");
            ladder = Ladder.newLadder(4, "-1");
        });
    }
}
