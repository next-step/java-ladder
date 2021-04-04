package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class PlayersTest {
    @ParameterizedTest
    @DisplayName(value = "참가자 생성 인원수")
    @CsvSource(value = {"james,kim,jade,lee,choi:5", "james,kim:2"}, delimiter = ':')
    void playersCount(String input, int result) {
        assertThat(new Players(input)
                .countOfPlayers())
                .isEqualTo(result);
    }

    @Test
    @DisplayName(value = "참가자 객체 생성")
    void playersArgumentsException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Players("");
                }).withMessageMatching("참가자의 이름은 비어있는 값 일 수 없습니다.");
    }
}