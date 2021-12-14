package nextstep.ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import nextstep.ladder.exception.NotEnoughPlayersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,honux,crong,jk:4", "kim,dong,hyo:3"}, delimiter = ':')
    @DisplayName("생성 성공")
    void create(String players, int size) {
        assertThat(Players.of(new InputString(players)).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hyo"})
    @DisplayName("인원이 모자를 경우 예외처리")
    void notEnoughPlayersException(String players) {
        assertThatExceptionOfType(NotEnoughPlayersException.class)
            .isThrownBy(() -> Players.of(new InputString(players)));
    }

}
