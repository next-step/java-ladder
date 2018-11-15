package domain.ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayerTest {

    @Test
    public void 플레이어_생성여부() {
        Player player = new Player("pobi");
        assertThat(player.getName()).isEqualTo("pobi");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_이름_길이() {
        Player player = new Player("pobiCo");
    }
}