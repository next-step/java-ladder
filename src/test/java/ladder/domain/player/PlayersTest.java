package ladder.domain.player;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @ParameterizedTest(name = "참가자들의 이름 null 또는 빈값 {index} [{arguments}]")
    @MethodSource
    @DisplayName("생성 실패")
    void construct_exception(String playersName, int lengthOfName) {
        //given

        //when
        ThrowingCallable actual = () -> Players.of(playersName);

        //then
        assertThatThrownBy(actual).isInstanceOf(PlayerNameException.class)
                .hasMessage("참가자의 이름은 1~5글자만 허용됩니다. 이름 길이 : " + lengthOfName);

    }

    private static Stream<Arguments> construct_exception() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of("", 0)
        );
    }

    @Test
    @DisplayName("부족한 참가자 수")
    void players_size_exception() {
        //given
        String name = "pro";

        //when
        ThrowingCallable actual = () -> Players.of(name);

        //then
        assertThatThrownBy(actual).isInstanceOf(PlayersSizeException.class)
                .hasMessage("참가자는 2명 이상이어야 합니다.");

    }

    @ParameterizedTest(name = "참가자 인원 수 {index} [{arguments}]")
    @CsvSource(value = {
            "pro,semi,ama:3",
            "pro,ama:2"
    }, delimiter = ':')
    @DisplayName("참가자 인원 수")
    void players_size(String playersName, int expected) {
        //given
        Players players = Players.of(playersName);

        //when
        int actual = players.size();

        //then
        assertThat(actual).isEqualTo(expected);

    }
}
