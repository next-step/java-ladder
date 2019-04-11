package domain;

import org.junit.Test;

public class PlayerTest {
    private Player player;

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_없음() {
        String name = null;
        this.player = new Player(name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 참여자_이름_5글자_초과() {
        String name = "helloPlayer";
        this.player = new Player(name);
    }

    @Test
    public void 참여자_이름_5글자_이하() {
        String input = "shina";
        this.player = new Player(input);
    }
}
