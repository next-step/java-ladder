package dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void 이름수초과() {
        new Player("ecycle");
    }

    @Test
    public void 플레이어매치() {
       Player player = new Player("test");
       assertThat(player.equals("test")).isTrue();
    }
}
