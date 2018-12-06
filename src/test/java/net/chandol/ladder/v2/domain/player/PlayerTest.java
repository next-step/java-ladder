package net.chandol.ladder.v2.domain.player;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PlayerTest {
    @Test(expected = IllegalArgumentException.class)
    public void nullOrEmptyTest() {
        new Player(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyNameTest() {
        new Player("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceedLengthTest() {
        new Player("123456");
    }

    @Test
    public void getFixedCenterNameValue() {
        Player player = new Player("aa");

        String fixedLengthName = player.getNameWithFixedLength();
        Assertions.assertThat(fixedLengthName).isEqualTo(" aa  ");
    }
}
