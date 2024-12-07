package ladder.domain.ns;

import ladder.domain.interfaces.Line;
import ladder.domain.interfaces.Lines;
import ladder.domain.interfaces.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.ns.NsLadderTest.VERTICAL_LADDER_SIZE;
import static ladder.domain.ns.PlayerNameTest.*;
import static ladder.domain.ns.NsPlayersTest.POBI_HONUX_CRONG_JK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NsLinesTest {

    @Test
    @DisplayName("라인목록을 생성한다")
    void create() {
        Players players = new NsPlayers(POBI_HONUX_CRONG_JK);
        Lines actual = new NsLines(players, VERTICAL_LADDER_SIZE, () -> false);
        Line falseLine = new NsLine(players.size(), () -> false);
        Lines expected = new NsLines(List.of(falseLine, falseLine, falseLine, falseLine, falseLine));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인목록을 조회한다")
    void getLines() {
        Players players = new NsPlayers(POBI_HONUX_CRONG_JK);
        Line falseLine = new NsLine(players.size(), () -> false);
        ArrayList<Line> lineList = new ArrayList<>(List.of(falseLine, falseLine, falseLine, falseLine, falseLine));
        Lines lines = new NsLines(lineList);
        List<Line> actual = lines.getLines();

        assertThat(actual).isEqualTo(lineList);
        assertThatThrownBy(() -> {
            actual.add(new NsLine(players.size(), () -> false));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("플레이어 모두 마지막까지 이동")
    void move() {
        //    |-----|     |-----| pobi  honux crong jk    0
        //    |     |-----|     | honux pobi  jk    crong 1
        //    |-----|     |     | honux jk    pobi  crong 2
        //    |     |-----|     | jk    honux pobi  crong 3
        //    |-----|     |-----| jk    pobi  honux crong 4
        //    results             pobi  jk    crong honux 5
        NsPoint p1_1 = NsPoint.first(true),
                p1_2 = p1_1.next(false),
                p1_3 = p1_2.next(true),
                p1_4 = p1_3.last();

        NsPoint p2_1 = NsPoint.first(false),
                p2_2 = p2_1.next(true),
                p2_3 = p2_2.next(false),
                p2_4 = p2_3.last();

        NsPoint p3_1 = NsPoint.first(true),
                p3_2 = p3_1.next(false),
                p3_3 = p3_2.next(false),
                p3_4 = p3_3.last();

        Lines lines = new NsLines(List.of(
                new NsLine(List.of(p1_1, p1_2, p1_3, p1_4)),
                new NsLine(List.of(p2_1, p2_2, p2_3, p2_4)),
                new NsLine(List.of(p3_1, p3_2, p3_3, p3_4)),
                new NsLine(List.of(p2_1, p2_2, p2_3, p2_4)),
                new NsLine(List.of(p1_1, p1_2, p1_3, p1_4))
        ));

        Players actual = lines.move(new NsPlayers(POBI_HONUX_CRONG_JK));
        Players expected = new NsPlayers(
                List.of(PLAYER_NAME_POBI, PLAYER_NAME_JK, PLAYER_NAME_CRONG, PLAYER_NAME_HONUX),
                new Vertical(5));

        assertThat(actual).isEqualTo(expected);
    }


}