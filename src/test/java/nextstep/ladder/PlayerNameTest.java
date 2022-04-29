package nextstep.ladder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class PlayerNameTest {

    @Test
    void create() {
        PlayerName playerName = new PlayerName("wang");
        assertThat(playerName).isEqualTo(new PlayerName("wang"));
    }

    @Test
    void invalidPlayerName() {
        assertThatThrownBy(() -> new PlayerName("WangTak"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyPlayerName(String playerName) {
        assertThatThrownBy(() -> new PlayerName(playerName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
