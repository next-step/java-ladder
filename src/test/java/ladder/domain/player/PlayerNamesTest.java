package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import ladder.exception.InvalidPlayerNameException;
import ladder.exception.InvalidPlayerNamesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PlayerNamesTest {

    PlayerNames playerNames;

    @BeforeEach
    void setUp() {
        playerNames = PlayerNames.of(Arrays.asList("pobi", "honux", "crong", "jk"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void name(List<String> names) {
        assertThatThrownBy(() -> PlayerNames.of(names))
                .isInstanceOf(InvalidPlayerNamesException.class);
    }

    @Test
    void getNameByIndex() {
        PlayerName playerName = playerNames.getNameByIndex(1);
        assertThat(playerName).isEqualTo(PlayerName.of("honux"));
    }

    @Test
    void getNameByIndex_InvalidIndex() {
        assertThatThrownBy(() -> playerNames.getNameByIndex(5))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void getIndexByName() {
        assertThat(playerNames.getIndexByName("pobi")).isZero();
    }

    @Test
    void getIndexByName_InvalidName() {
        assertThatThrownBy(() -> playerNames.getIndexByName("gazua"))
                .isInstanceOf(InvalidPlayerNameException.class);
    }
}
