package domain.ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderManageTest {

    @Test
    public void 플레이어_라인_생성여부() {
        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        line.add(new Line(Arrays.asList(true, false, false)));

        List<Player> player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));

        LadderManage ladderManage = new LadderManage(player, line);
        assertThat(ladderManage.getLines().getLine()).hasSize(2);
        assertThat(ladderManage.getPlayers().getPlayerLocation("pobi")).isEqualTo(0);

    }

    @Test
    public void 플레이어_ALL_플레이_생성여부() {
        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        line.add(new Line(Arrays.asList(true, false, false)));
        Lines lInes = new Lines(line);

        List<Player> player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));
        Players players = new Players(player);

        LadderManage ladderManage = new LadderManage(player, line);
        Laddering allUser = ladderManage.play("ALL");
        assertThat(allUser.getPlayers()).isEqualTo(new Laddering(players, lInes).getPlayers());
        assertThat(allUser.getLines().getLine()).isEqualTo(new Laddering(players, lInes).getLines().getLine());

    }

    @Test
    public void 플레이어_플레이_생성여부() {
        List<Line> line = new ArrayList<>();
        line.add(new Line(Arrays.asList(true, false, true)));
        line.add(new Line(Arrays.asList(true, false, false)));
        Lines lInes = new Lines(line);

        List<Player> player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));
        Players players = new Players(player);

        LadderManage ladderManage = new LadderManage(player, line);
        Laddering user = ladderManage.play("pobi");

        List<Player> findPlayers =  new ArrayList<>();
        findPlayers.add(new Player("pobi"));
        Players findPlayer = new Players(findPlayers);

        assertThat(user.getPlayers()).isEqualTo(findPlayer);

    }
}