package ladder;

import ladder.domain.LadderLine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {
    @Test
    public void init() {
        int sizeOfPerson = 5;
        assertThat(LadderLine.init(sizeOfPerson).getPoints().size())
                .isEqualTo(sizeOfPerson);
    }

    @Test
    public void move() {
        LadderLine line = LadderLine.init(2);
        System.out.println("ladder result : " + line.move(0));
    }
}
