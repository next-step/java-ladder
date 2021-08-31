package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PlayersTest {

    @DisplayName("플레이어들 ")
    @Test
    void create() {
        assertThat(new Players(Arrays.asList("AAA", "BBB"))).isEqualTo(new Players(Arrays.asList("AAA", "BBB")));
    }
}