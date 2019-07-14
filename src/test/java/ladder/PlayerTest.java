package ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    @Test
    void createPlayer() {
        Player player = Player.of("name");
        assertThat(player.getName()).isEqualTo("name");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void palyerNameNullOrEmpty(String name) {
        assertThatIllegalArgumentException().isThrownBy(()-> Player.of(name));

    }

    @Test
    void playerNameSize6() {
        assertThatIllegalArgumentException().isThrownBy(()-> Player.of("name66"));
    }

    @Test
    void contain() {
        Player player = Player.of("name");
        assertThat(player.contain("name")).isTrue();
    }
}
