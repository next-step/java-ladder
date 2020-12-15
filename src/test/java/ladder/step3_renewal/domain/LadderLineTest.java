package ladder.step3_renewal.domain;

import org.junit.jupiter.api.Test;
import step3_renewal.domain.Ladder;
import step3_renewal.domain.LadderLine;
import step3_renewal.domain.LadderRandomGenerator;

public class LadderLineTest {

    @Test
    public void init() {
        int sizeOfPersonal = 5;
        System.out.println(LadderLine.init(sizeOfPersonal, new LadderRandomGenerator()));
    }

    @Test
    public void move() {
        LadderLine ladderLine = LadderLine.init(5, new LadderRandomGenerator());
        System.out.println("ladder result : " + ladderLine.move(3));
    }

}
