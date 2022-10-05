package ladder.step2.domain;

import ladder.step2fixture.domain.PlayersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @Test
    @DisplayName("여러 플레이어들의 일급 콜렉션 생성")
    void create() {
        assertThat(PlayersFixture.PLAYERS).isNotNull();
    }
}
