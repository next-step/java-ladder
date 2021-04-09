package ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {
    @DisplayName("참가자들을 인자로 받아 인스턴스를 생성한다.")
    @Test
    void create() {
        Players players = new Players(Arrays.asList("test1", "test2", "test3"));
        assertThat(players).isEqualTo(new Players(Arrays.asList("test1", "test2", "test3")));
    }
}
