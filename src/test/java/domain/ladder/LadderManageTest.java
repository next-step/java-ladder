package domain.ladder;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderManageTest {

    @Test
    public void 플레이어_라인_생성여부() {
        List<Point> points1 = new ArrayList<>();
        points1.add(new Point(0, Direction.of(false,true)));
        points1.add(new Point(1, Direction.of(true,false)));
        points1.add(new Point(2, Direction.of(false,true)));
        LadderLine ladderLine = new LadderLine(points1);
        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(0, Direction.of(false,false)));
        points2.add(new Point(1, Direction.of(false,true)));
        points2.add(new Point(2, Direction.of(false,false)));
        LadderLine ladderLine2 = new LadderLine(points2);
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(ladderLine);
        ladderLines.add(ladderLine2);

        List<Player> player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));

        LadderManage ladderManage = new LadderManage(player, ladderLines);
        assertThat(ladderManage.getLines().getLine()).hasSize(2);
        assertThat(ladderManage.getPlayers().getPlayerLocation("pobi")).isEqualTo(0);

    }

    @Test
    public void 플레이어_ALL_플레이_생성여부() {
        List<Point> points1 = new ArrayList<>();
        points1.add(new Point(0, Direction.of(false,true)));
        points1.add(new Point(1, Direction.of(true,false)));
        points1.add(new Point(2, Direction.of(false,true)));
        LadderLine ladderLine = new LadderLine(points1);
        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(0, Direction.of(false,false)));
        points2.add(new Point(1, Direction.of(false,true)));
        points2.add(new Point(2, Direction.of(false,false)));
        LadderLine ladderLine2 = new LadderLine(points2);
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(ladderLine);
        ladderLines.add(ladderLine2);
        Lines lines = new Lines(ladderLines);

        List<Player> player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));
        Players players = new Players(player);

        LadderManage ladderManage = new LadderManage(player, ladderLines);
        Laddering allUser = ladderManage.play("ALL");
        assertThat(allUser.getPlayers()).isEqualTo(new Laddering(players, lines).getPlayers());
        assertThat(allUser.getLines().getLine()).isEqualTo(new Laddering(players, lines).getLines().getLine());

    }

    @Test
    public void 플레이어_플레이_생성여부() {
        List<Point> points1 = new ArrayList<>();
        points1.add(new Point(0, Direction.of(false,true)));
        points1.add(new Point(1, Direction.of(true,false)));
        points1.add(new Point(2, Direction.of(false,true)));
        LadderLine ladderLine = new LadderLine(points1);
        List<Point> points2 = new ArrayList<>();
        points2.add(new Point(0, Direction.of(false,false)));
        points2.add(new Point(1, Direction.of(false,true)));
        points2.add(new Point(2, Direction.of(false,false)));
        LadderLine ladderLine2 = new LadderLine(points2);
        List<LadderLine> ladderLines = new ArrayList<>();
        ladderLines.add(ladderLine);
        ladderLines.add(ladderLine2);

        List<Player> player =  new ArrayList<>();
        player.add(new Player("pobi"));
        player.add(new Player("crox"));
        Players players = new Players(player);

        LadderManage ladderManage = new LadderManage(player, ladderLines);
        Laddering user = ladderManage.play("pobi");

        List<Player> findPlayers =  new ArrayList<>();
        findPlayers.add(new Player("pobi"));
        Players findPlayer = new Players(findPlayers);

        assertThat(user.getPlayers()).isEqualTo(findPlayer);

    }
}