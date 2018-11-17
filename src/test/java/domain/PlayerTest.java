package domain;

import org.junit.Test;
import utils.StringUtils;
import view.ResultView;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlayerTest {
    @Test
    public void 플레이어만들기내부로직테스트() {
        String names = "stron,box,test,kkk,sdfa";
        List<Player> players = StringUtils.joinPlayer(StringUtils.splitDelemeter(names));
        String[] playerNames = names.split(",");
        for (String playerName : playerNames) {
            Player player = new Player(playerName);
        }
        assertThat("kkk").isEqualTo(playerNames[3]);

        ResultView.printNames(players);
    }

    @Test
    public void 플레이어만들기테스트() {
        String names = "stron,box,test,kkk,sdfa";
        List<Player> players = StringUtils.joinPlayer(StringUtils.splitDelemeter(names));
        assertThat(players.get(3).isPlayerName("kkk")).isTrue();

    }


    @Test(expected = RuntimeException.class)
    public void 글자수테스트() {
        String names = "stronxxx,box,test,kkk,sdfa";
        StringUtils.joinPlayer(StringUtils.splitDelemeter(names));

    }
}