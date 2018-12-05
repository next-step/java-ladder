package dto;

import org.junit.Test;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void 이름수초과() {
        new Player("ecycle");
    }
}
