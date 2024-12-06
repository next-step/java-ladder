package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.LadderTest.VERTICAL_LADDER_SIZE;
import static ladder.domain.PlayerNameTest.*;
import static ladder.domain.PlayersTest.POBI_HONUX_CRONG_JK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinesTest {

    @Test
    @DisplayName("라인목록을 생성한다")
    void create() {
        Players players = new Players(POBI_HONUX_CRONG_JK);
        Lines actual = new Lines(players, VERTICAL_LADDER_SIZE, () -> false);
        Lines expected = new Lines(List.of(
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false)
        ));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인목록을 조회한다")
    void getLines() {
        Players players = new Players(POBI_HONUX_CRONG_JK);
        ArrayList<Line> lineList = new ArrayList<>(List.of(
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false),
                new Line(players.size(), () -> false)
        ));
        Lines lines = new Lines(lineList);
        List<Line> actual = lines.getLines();

        assertThat(actual).isEqualTo(lineList);
        assertThatThrownBy(() -> {
            actual.add(new Line(players.size(), () -> false));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("플레이어 모두 마지막까지 이동")
    void move() {
        //    |-----|     |-----|
        //    |     |-----|     |
        //    |-----|     |     |
        //    |     |-----|     |
        //    |-----|     |-----|
        Point p1_1 = Point.first(true),
        p1_2 = p1_1.next(false),
        p1_3 = p1_2.next(true),
        p1_4 = p1_3.last();

        Point p2_1 = Point.first(false),
        p2_2 = p2_1.next(true),
        p2_3 = p2_2.next(false),
        p2_4 = p2_3.last();

        Point p3_1 = Point.first(true),
        p3_2 = p3_1.next(false),
        p3_3 = p3_2.next(false),
        p3_4 = p3_3.last();

        Point p4_1 = p2_1,
        p4_2 = p2_2,
        p4_3 = p2_3,
        p4_4 = p2_4;

        Point p5_1 = p1_1,
        p5_2 = p1_2,
        p5_3 = p1_3,
        p5_4 = p1_4;

        //    |-----|     |-----| pobi  honux crong jk    0
        //    |     |-----|     | honux pobi  jk    crong 1
        //    |-----|     |     | honux jk    pobi  crong 2
        //    |     |-----|     | jk    honux pobi  crong 3
        //    |-----|     |-----| jk    pobi  honux crong 4
        //    results             pobi  jk    crong honux 5
        Lines lines = new Lines(List.of(
                new Line(List.of(p1_1, p1_2, p1_3, p1_4)),
                new Line(List.of(p2_1, p2_2, p2_3, p2_4)),
                new Line(List.of(p3_1, p3_2, p3_3, p3_4)),
                new Line(List.of(p4_1, p4_2, p4_3, p4_4)),
                new Line(List.of(p5_1, p5_2, p5_3, p5_4))
        ));

        Players actual = lines.move(new Players(POBI_HONUX_CRONG_JK));
        Players expected = new Players(List.of(PLAYER_NAME_POBI, PLAYER_NAME_JK, PLAYER_NAME_CRONG, PLAYER_NAME_HONUX),
                new Vertical(5));

        assertThat(actual).isEqualTo(expected);
    }


}