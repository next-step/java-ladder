package nextstep.ladder.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerCountTest {
    @ParameterizedTest(name = "create: {arguments}")
    @ValueSource(ints = {2, 5})
    public void create(final int playerCount) {
        assertThat(PlayerCount.of(playerCount)).isEqualTo(PlayerCount.of(playerCount));
    }

    @ParameterizedTest(name = "create failed : {arguments}")
    @ValueSource(ints = {-1, 0, 1})
    public void createFailed(final int playerCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> PlayerCount.of(playerCount));
    }

    @ParameterizedTest(name = "toInt: {arguments}")
    @ValueSource(ints = {2, 5})
    public void toInt(final int playerCount) {
        assertThat(PlayerCount.of(playerCount).toInt()).isEqualTo(playerCount);
    }

    @ParameterizedTest(name = "cache: {arguments}")
    @ValueSource(ints = {2, 5})
    public void cache(final int playerCount) {
        assertThat(PlayerCount.of(playerCount) == PlayerCount.of(playerCount)).isTrue();
    }

    public static PlayerCount pc(int playerCount) {
        return PlayerCount.of(playerCount);
    }
}
