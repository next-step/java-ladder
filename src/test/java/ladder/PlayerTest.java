package ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    @Test
    void createPlayer() {
        Player player = new Player("name");
        assertThat(player.getName()).isEqualTo("name");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void palyerNameNullOrEmpty(String name) {
        assertThatIllegalArgumentException().isThrownBy(()-> new Player(name));

    }

    @Test
    void playerNameSize6() {
        assertThatIllegalArgumentException().isThrownBy(()-> new Player("name66"));
    }
}
