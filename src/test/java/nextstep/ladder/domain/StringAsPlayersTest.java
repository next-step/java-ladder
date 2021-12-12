package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAsPlayersTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk"})
    @DisplayName("players 객체 생성")
    void createPlayers(String players) {
        assertThat(new StringAsPlayers(players).players()).isInstanceOf(Players.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 혹은 빈 값 예외처리")
    void nameNullPointerException(String players) {
        assertThatExceptionOfType(NullPointerException.class)
            .isThrownBy(() -> new StringAsPlayers(players));
    }

}
