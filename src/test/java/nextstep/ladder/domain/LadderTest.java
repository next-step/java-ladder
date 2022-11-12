package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    public void create() {
        Ladder game = new Ladder(List.of("test1", "test2"), 5);
        assertThat(game.getPlayerCount()).isEqualTo(2);

        assertThatThrownBy(() -> new Ladder(List.of("short", "too long name"), 10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
