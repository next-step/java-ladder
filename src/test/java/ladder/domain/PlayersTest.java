package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    @DisplayName("사람 이름이 연속해서 출력되어야 한다.")
    void testToString() {
        assertThat(
                new Players(Arrays.asList(
                        new Player("1"),
                        new Player("22"),
                        new Player("333"),
                        new Player("4444"),
                        new Player("55555")
                )).toString()
        ).isEqualTo("     1    22   333  4444 55555");
    }
}
