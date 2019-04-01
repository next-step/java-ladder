package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    public void 플레이어이름_5자() {
        // given
        String name = "하하하하하";
        // when
        Player player = new Player(name);
        // then
        assertThat(player.getName()).isEqualTo(name);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어이름_5자초과() {
        // given
        String name = "하하하하하하";
        // when
        Player player = new Player(name);
        // then
    }

    @Test
    public void 플레이어이름4자_출력시_길이6() {
        // given
        String name = "하하하하";
        // when
        Player player = new Player(name);
        // then
        assertThat(player.toString().length()).isEqualTo(5);
    }

    @Test
    public void 플레이어이름5자_출력시_길이() {
        // given
        String name = "하하하하하";
        // when
        Player player = new Player(name);
        // then
        assertThat(player.toString().length()).isEqualTo(5);
    }
}
