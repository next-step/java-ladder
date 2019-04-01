package laddergame.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LevelTest {

    @Test(expected = IllegalArgumentException.class)
    public void getLevel_null_key() {
        Level.getLevel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLevel_empty_key() {
        Level.getLevel("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void getLevel_invalid_key() {
        Level.getLevel("dlkjfkdj");
    }

    @Test
    public void getLevel() {
        assertThat(Level.getLevel("상")).isEqualTo(Level.HARD);
        assertThat(Level.getLevel("중")).isEqualTo(Level.MEDIUM);
        assertThat(Level.getLevel("하")).isEqualTo(Level.EASY);
    }
}