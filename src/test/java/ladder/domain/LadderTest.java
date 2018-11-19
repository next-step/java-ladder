package ladder.domain;

import org.junit.Test;

public class LadderTest {
    @Test
    public void 생성() {
        int countOfPlayer = 3;
        int height = 5;
        Ladder.of(height, countOfPlayer);
    }
}
