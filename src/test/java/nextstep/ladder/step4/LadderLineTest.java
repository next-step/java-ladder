package nextstep.ladder.step4;

import org.junit.jupiter.api.Test;

public class LadderLineTest {
    @Test
    void init() {
        int sizeOfPerson = 5;
        LadderLine ladderLine = LadderLine.init(sizeOfPerson);
        System.out.println(ladderLine);
    }
}
