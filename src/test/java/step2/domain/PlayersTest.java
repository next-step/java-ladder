package step2.domain;

import org.junit.jupiter.api.Test;
import step2.dto.Player;
import step2.dto.Players;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    void createPlayersFailTest() {
        String[] input = "aaa,bb,ccc,ddddd,eeeeee".split(",");
        assertThatThrownBy(() -> new Players(input))
                .isExactlyInstanceOf(RuntimeException.class)
                .hasMessage("사람 이름은 최대 5글자 입니다.");
    }

    @Test
    void createPlayersSuccessTest() {
        String[] input = "aaa,bb,ccc,ddddd,eeeee".split(",");
        final Players actual = new Players(input);
        final Players expected = new Players(Arrays.asList(new Player("aaa"),
                new Player("bb"),
                new Player("ccc"),
                new Player("ddddd"),
                new Player("eeeee")));
        assertThat(actual).isEqualTo(expected);
    }
}