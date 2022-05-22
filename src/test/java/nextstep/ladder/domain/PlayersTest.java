package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    void countOfLines() {
        assertThat(Players.of(List.of("jack", "pobi")).countOfLines()).isEqualTo(1);
    }
}
