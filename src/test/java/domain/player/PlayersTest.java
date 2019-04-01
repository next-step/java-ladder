package domain.player;

import org.junit.*;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    @Test
    public void test_크기() {
        Players players = Players.generate("pobi, honux, crong, jk");
        assertThat(players.size())
                .isEqualTo(4);
    }

    @Test
    public void test_인덱스_검색() {
        Players players = Players.generate("pobi, honux, crong, jk");
        assertThat(players.findIndexByName("jk"))
                .isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_인덱스_검색_실패_잘못된_이름() {
        Players players = Players.generate("pobi, honux, crong, jk");
        players.findIndexByName("");
    }

    @Test
    public void test_사용자목록_출력() {
        Players players = Players.generate("pobi, honux, crong, jk");

        assertThat(players.beautify())
                .isEqualTo(" pobi honux crong    jk");
    }
}
