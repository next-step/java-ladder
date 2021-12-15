package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;

import static nextstep.ladder.domain.NameTest.n;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {
    @Test
    public void create() {
        final String name = "name";
        assertThat(Player.of(name)).isEqualTo(Player.of(name));
        assertThat(Player.of(n(name))).isEqualTo(Player.of(name));
    }

    @ParameterizedTest(name = "create failed: {arguments}")
    @NullSource
    public void createFailed(Name name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Player.of(name))
                .withMessageContaining("cannot be null");
    }

    @Test
    public void name() {
        final Name name = n("name1");
        assertThat(Player.of(name).name()).isEqualTo(name);
    }

    public static Player p(String name) {
        return Player.of(name);
    }
}
