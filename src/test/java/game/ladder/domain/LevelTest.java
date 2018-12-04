package game.ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LevelTest {

    @Test
    public void getLevel_high() {
        final int high1 = Level.MAXIMUM_RATE;
        final int high2 = Level.MAXIMUM_RATE - 20;

        assertThat(Level.getLevel(high1)).isSameAs(Level.HIGH);
        assertThat(Level.getLevel(high2)).isSameAs(Level.HIGH);
    }

    @Test
    public void getLevel_middle() {
        final int middle1 = Level.MAXIMUM_RATE - 30;
        final int middle2 = Level.MAXIMUM_RATE - 21;

        assertThat(Level.getLevel(middle1)).isSameAs(Level.MIDDLE);
        assertThat(Level.getLevel(middle2)).isSameAs(Level.MIDDLE);
    }

    @Test
    public void getLevel_low() {
        final int low1 = Level.MAXIMUM_RATE - 50;
        final int low2 = Level.MINIMUM_RATE;

        assertThat(Level.getLevel(low1)).isSameAs(Level.LOW);
        assertThat(Level.getLevel(low2)).isSameAs(Level.LOW);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLevel_0_넘길때() {

        Level.getLevel(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLevel_101_넘길때() {

        Level.getLevel(101);
    }
}