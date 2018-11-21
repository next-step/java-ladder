package domain.ladder;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderManageTest {

    List<Player> player;
    List<LadderLine> ladderLines;
    LadderManage ladderManage;
    Players players;

    @Before
    public void init(){
        List<Point> points = new ArrayList<>();
        points.add(Point.of(0, Direction.of(false,true)));
        points.add(Point.of(1, Direction.of(true,false)));
        points.add(Point.of(2, Direction.of(false,false)));
        LadderLine ladderLine = new LadderLine(points);
        ladderLines = new ArrayList<>();
        ladderLines.add(ladderLine);
        player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));
        player.add(new Player("crong"));
        players = new Players(player);
        ladderManage = new LadderManage(player, ladderLines);
    }

    @Test
    public void 플레이어_라인_생성여부() {
        assertThat(ladderManage.getLines().getLine()).hasSize(1);
        assertThat(ladderManage.getPlayers().getPlayerLocation("pobi")).isEqualTo(0);
    }

    @Test
    public void 플레이어_ALL_플레이_생성여부() {
        Lines lines = new Lines(ladderLines);
        Laddering allUser = ladderManage.play("ALL");

        assertThat(allUser.getPlayers()).isEqualTo(new Laddering(players, lines).getPlayers());
        assertThat(allUser.getLines().getLine()).isEqualTo(new Laddering(players, lines).getLines().getLine());
    }

    @Test
    public void 플레이어_플레이_이동여부() {
        Laddering user = ladderManage.play("pobi");

        assertThat(user.getLocation(0)).isEqualTo(1);
    }

    @Test
    public void 플레이어_플레이_ALL_이동여부() {
        Laddering user = ladderManage.play("ALL");

        assertThat(user.getLocation(0)).isEqualTo(1);
        assertThat(user.getLocation(1)).isEqualTo(0);
        assertThat(user.getLocation(2)).isEqualTo(2);
    }
}