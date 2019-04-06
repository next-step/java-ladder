package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {


    @Test
    public void 플레이어_이름은_다섯글자_이하_생성_가능() {
        String playerName = "일이삼사오";
        Player player = new Player(new PlayerName(playerName));
        assertThat(player.getName()).isEqualTo(playerName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_이름은_다섯글자_초과_생성_불가능() {
        String playerName = "여섯글자이름";
        new Player(new PlayerName(playerName));
    }


    @Test(expected = IllegalArgumentException.class)
    public void 플레이어_이름_빈값_생성_불가() {
        String playerName = "";
        new Player(new PlayerName(playerName));
    }

}
