package ladder.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test(expected = IllegalArgumentException.class)
    public void 사람_이름은_최대_다섯_글자() {
        // given
        // when
        // then
        new Player("javajigi");
    }

    @Test
    public void 사람_생성() {
        // given
        final String name = "jason";

        // when
        final Player player = new Player(name);

        // then
        assertThat(player.getName()).isEqualTo(name);
    }
}