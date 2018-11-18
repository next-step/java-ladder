package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PlayerTest {

    @Test
    public void 생성() {
        assertThat(Player.of("korna")).isEqualTo(Player.of("korna"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름_5자리초과_검증() {
        Player.of("korkorna");
    }
}