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
    Lines lines;

    @Before
    public void init(){
        List<Point> points1 = new ArrayList<>();
        points1.add(Point.of(0, Direction.of(false,true)));
        points1.add(Point.of(1, Direction.of(true,false)));
        points1.add(Point.of(2, Direction.of(false,true)));
        LadderLine ladderLine = new LadderLine(points1);
        List<Point> points2 = new ArrayList<>();
        points2.add(Point.of(0, Direction.of(false,false)));
        points2.add(Point.of(1, Direction.of(false,true)));
        points2.add(Point.of(2, Direction.of(false,false)));
        LadderLine ladderLine2 = new LadderLine(points2);
        ladderLines = new ArrayList<>();
        ladderLines.add(ladderLine);
        ladderLines.add(ladderLine2);
        lines = new Lines(ladderLines);

        player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));
        players = new Players(player);

        ladderManage = new LadderManage(player, ladderLines);
    }

    @Test
    public void 플레이어_라인_생성여부() {
        assertThat(ladderManage.getLines().getLine()).hasSize(2);
        assertThat(ladderManage.getPlayers().getPlayerLocation("pobi")).isEqualTo(0);

    }

    @Test
    public void 플레이어_ALL_플레이_생성여부() {
        Laddering allUser = ladderManage.play("ALL");
        assertThat(allUser.getPlayers()).isEqualTo(new Laddering(players, lines).getPlayers());
        assertThat(allUser.getLines().getLine()).isEqualTo(new Laddering(players, lines).getLines().getLine());

    }

    @Test
    public void 플레이어_플레이_생성여부() {
        Laddering user = ladderManage.play("pobi");

        List<Player> findPlayers =  new ArrayList<>();
        findPlayers.add(new Player("pobi"));
        Players findPlayer = new Players(findPlayers);

        assertThat(user.getPlayers()).isEqualTo(findPlayer);
    }
}