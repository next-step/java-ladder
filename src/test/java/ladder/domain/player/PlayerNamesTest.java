package ladder.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import ladder.exception.InvalidPlayerNamesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class PlayerNamesTest {

    private PlayerNames playerNames;

    @BeforeEach
    void setUp() {
        playerNames = PlayerNames.of(Arrays.asList(
                PlayerName.of("pobi"),
                PlayerName.of("honux"),
                PlayerName.of("crong"),
                PlayerName.of("jk")));
    }

    @ParameterizedTest(name = "{index} invalid input to constructor: {0}")
    @NullAndEmptySource
    void invalid_of(List<PlayerName> playerNames) {
        assertThatThrownBy(() ->
                PlayerNames.of(playerNames))
                .isInstanceOf(InvalidPlayerNamesException.class);
    }

    @Test
    void countOfPeople() {
        assertThat(playerNames.countOfPeople()).isEqualTo(4);
    }

    @Test
    void maxNameLength() {
        assertThat(playerNames.maxNameLength()).isEqualTo(5);
    }
}
