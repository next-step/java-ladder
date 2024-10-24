package ladder;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

class PlayersOldTest {

    @Test
    void 문자열을_받아서_참가자를_생성한다() {
        List<PlayerOld> playerOldList = List.of(
            new PlayerOld("pobi"),
            new PlayerOld("honux"),
            new PlayerOld("crong"),
            new PlayerOld("jk")
        );

        PlayersOld playersOld = new PlayersOld(playerOldList);
        assertThat(playersOld).isEqualTo(new PlayersOld("pobi", "honux", "crong", "jk"));
    }

    @Test
    void 참가자_수는_2명_이상이어야_한다() {
        assertThatThrownBy(() -> new PlayersOld("pobi"))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 해당_순서의_유저_이름을_반환한다() {
        List<PlayerOld> playerOldList = List.of(
            new PlayerOld("pobi"),
            new PlayerOld("honux"),
            new PlayerOld("crong"),
            new PlayerOld("jk")
        );

        PlayersOld playersOld = new PlayersOld(playerOldList);
        String playerName = playersOld.get(0);

        assertThat(playerName).isEqualTo("pobi");
    }

    @Test
    void 참가자들의_이름은_중복될_수_없다() {
        assertThatThrownBy(() -> new PlayersOld("lili", "lili", "lili"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("player name is not distinct");
    }
}
