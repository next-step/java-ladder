package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayersTest {
    @Test
    void 참여자_길이_테스트(){
        assertThatIllegalArgumentException().isThrownBy(
                () -> new Players(List.of(new Player("kbc"))));
    }

    @Test
    void toString_테스트(){
        Players players = new Players(List.of(new Player("kbc"), new Player("kbc2")));

        String result = players.toString();

        assertThat(result).isEqualTo("   kbc  kbc2");
    }

    @ParameterizedTest
    @CsvSource(delimiter = ':', value = {"kbc:0", "kbc3:2", "kbc4:3"})
    void Player_위치_반환_테스트(String name, int expected){
        Players players = new Players(List.of(new Player("kbc"), new Player("kbc2"), new Player("kbc3"), new Player("kbc4")));

        int index = players.indexOf(name);

        assertThat(index).isEqualTo(expected);
    }

    @Test
    void 없는_Player_찾기_유효성_체크(){
        Players players = new Players(List.of(new Player("kbc"), new Player("kbc2")));

        assertThatIllegalArgumentException().isThrownBy(
                () -> players.indexOf("kbc3"));
    }



}
