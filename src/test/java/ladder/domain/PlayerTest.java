package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @Test(expected = IllegalArgumentException.class)
    public void 이름_5글자이상일때() {
        Player player = new Player("abcdefg", 0);
    }

    @Test
    public void 이름_5글자일때() {
        Player player = new Player("abcde", 0);
        assertThat(player.toString().trim()).isEqualTo("abcde");
    }
}