package net.chandol.ladder.v1.domain.player;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void 이름은5글자이하여야합니다() {
        new Player("123456");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름은빈값이되어선안됩니다() {
        new Player(null);
    }

    @Test
    public void 이름정상여부확인() {
        Player test = new Player("test");

        assertThat(test.getName()).isEqualTo("test");
    }

    @Test
    public void 이름길이반환() {
        Player player = new Player("test");
        assertThat(player.nameLength()).isEqualTo(4);
    }

}