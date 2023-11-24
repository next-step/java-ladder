package ladder_v2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class PlayersTest {

    @Test
    @DisplayName("Player는 최소 2명 이상이어야 합니다.")
    void testPlayers() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(() -> {
            new Players(List.of(new Name("pobi")));
        });
    }
}
