package ladder.model;

import ladder.exception.WrongParameterException;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @ParameterizedTest
    @CsvSource(value = {"a:0", "b:1", "c:2", "d:3"}, delimiter = ':')
    public void 플레이어_사다리_게임_순서_검증(String name, int expected) {
        Players players = Players.of(Arrays.array("a", "b", "c", "d"));

        Optional<Integer> result = players.findPlayerNumber(name);

        assertThat(result).isEqualTo(Optional.of(expected));
    }

    @Test
    public void all_결과_검증시_플레이어_없음_오류_없음_검증() {
        Players players = Players.of(Arrays.array("a", "b", "c", "d"));

        Optional<Integer> result = players.findPlayerNumber("all");

        assertThat(result).isEqualTo(Optional.empty());
    }

    @Test
    public void 플레이어_이름_존재하지_않는_경우_오류_검증() {
        assertThatThrownBy(() -> Players.of(Arrays.array("a", "b", "c", "d")).findPlayerNumber("bella"))
                .isInstanceOf(WrongParameterException.class);
    }
}