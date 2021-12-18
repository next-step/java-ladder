package nextstep.ladder.step4.domain.player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayersTest {

    @ParameterizedTest
    @ValueSource(strings = {"pobi,honux,crong,jk", "kim,dong,hyo"})
    @DisplayName("생성성공")
    void create(String input) {
        assertThat(Players.of(new StringAsSplit(input))).isInstanceOf(Players.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "dong", "hyo"})
    @DisplayName("사다리게임 최소 인원 수 예외처리")
    void sizeException(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Players.of(new StringAsSplit(input)));
    }

}
