package ladder.step3_renewal.domain;

import org.junit.jupiter.api.Test;
import step3_renewal.domain.LadderLine;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPersonal = 5;
        System.out.println(LadderLine.init(sizeOfPersonal, new TestLadderGenerator()));
    }

    @Test
    public void move() {
        LadderLine ladderLine = LadderLine.init(5, new TestLadderGenerator());
        assertThat(ladderLine.move(3)).isEqualTo(2);
    }
}
