package ladder.ladder.domain;

import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    public void init() {
        Ladder init = Ladder.init(5, 5);
        System.out.println(init);
    }

}
