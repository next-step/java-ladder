package step4.domain;

import org.junit.jupiter.api.Test;

class LadderLineTest {
    @Test
    void init() {
        LadderLine ladderLine = LadderLine.init(2);
        System.out.println("ladder result : " + ladderLine.move(0));
    }
}