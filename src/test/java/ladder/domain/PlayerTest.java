package ladder.domain;

import org.junit.Test;

public class PlayerTest {

    @Test (expected = IllegalArgumentException.class)
    public void 플레이어_이름이_5글자_넘는_경우() {
        Player player = new Player("jihan2");
    }
}