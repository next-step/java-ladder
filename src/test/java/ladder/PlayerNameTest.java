package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerNameTest {

    @Test
    public void 이름_생성_다섯글자_이하_가능() {
        String newName = "일이삼사오";
        PlayerName playerName = new PlayerName(newName);
        assertThat(playerName.getName()).isEqualTo(newName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름_생성_다섯글자_초과_불가능() {
        String newName = "일이삼사오육";
        PlayerName playerName = new PlayerName(newName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 이름_생성_길이_0_불가능() {
        String newName = "";
        PlayerName playerName = new PlayerName(newName);
    }
}
