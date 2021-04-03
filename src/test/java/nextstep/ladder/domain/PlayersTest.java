package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @ParameterizedTest
    @CsvSource(value = {"james,kim,jade,lee,choi:5", "james,kim:2"}, delimiter = ':')
    void 참가자_인원수(String input, int result) {
        assertThat(new Players(input)
                .countOfPlayers())
                .isEqualTo(result);
    }

    @Test
    void 참가자_생성_예외() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Players("");
                });
    }
}