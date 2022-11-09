package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayersTest {

    @Test
    public void create() {
        Players players1 = Players.of(List.of("A", "AAA", "AAAAA"));
        assertThat(players1.getSize()).isEqualTo(3);
        assertThatThrownBy(() -> Players.of(List.of("AAA", "AAAAAA")))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
