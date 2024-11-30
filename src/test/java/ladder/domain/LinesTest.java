package ladder.domain;

import ladder.domain.generator.CrossGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static ladder.domain.PlayersTest.PLAYERS1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LinesTest {

    private int playersCount;
    private CrossGenerator falseGenerator;
    private int verticalLadderSize;
    private Point p1_1, p1_2, p1_3, p1_4;
    private Point p2_1, p2_2, p2_3, p2_4;
    private Point p3_1, p3_2, p3_3, p3_4;
    private Point p4_1, p4_2, p4_3, p4_4;
    private Point p5_1, p5_2, p5_3, p5_4;

    @BeforeEach
    void setUp() {
        playersCount = PLAYERS1.size();
        verticalLadderSize = 5;
        falseGenerator = () -> false;

        // f t f t f
        // f f t f f
        // f t f f f
        // f f t f f
        // f t f t f
        p1_1 = Point.first(true);
        p1_2 = p1_1.next(false);
        p1_3 = p1_2.next(true);
        p1_4 = p1_3.last();

        p2_1 = Point.first(false);
        p2_2 = p2_1.next(true);
        p2_3 = p2_2.next(false);
        p2_4 = p2_3.last();

        p3_1 = Point.first(true);
        p3_2 = p3_1.next(false);
        p3_3 = p3_2.next(false);
        p3_4 = p3_3.last();

        p4_1 = p2_1;
        p4_2 = p2_2;
        p4_3 = p2_3;
        p4_4 = p2_4;

        p5_1 = p1_1;
        p5_2 = p1_2;
        p5_3 = p1_3;
        p5_4 = p1_4;
    }

    @Test
    @DisplayName("라인목록을 생성한다")
    void create() {
        Lines actual = new Lines(PLAYERS1, verticalLadderSize, falseGenerator);
        Lines expected = new Lines(List.of(
                new Line(playersCount, falseGenerator),
                new Line(playersCount, falseGenerator),
                new Line(playersCount, falseGenerator),
                new Line(playersCount, falseGenerator),
                new Line(playersCount, falseGenerator)
        ));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("라인목록을 조회한다")
    void getLines() {
        ArrayList<Line> lineList = new ArrayList<>(List.of(
                new Line(playersCount, falseGenerator),
                new Line(playersCount, falseGenerator),
                new Line(playersCount, falseGenerator),
                new Line(playersCount, falseGenerator),
                new Line(playersCount, falseGenerator)
        ));
        Lines lines = new Lines(lineList);
        List<Line> actual = lines.getLines();

        assertThat(actual).isEqualTo(lineList);
        assertThatThrownBy(() -> {
            actual.add(new Line(playersCount, falseGenerator));
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
        Lines lines = new Lines(List.of(
                new Line(List.of(p1_1, p1_2, p1_3, p1_4)),
                new Line(List.of(p2_1, p2_2, p2_3, p2_4)),
                new Line(List.of(p3_1, p3_2, p3_3, p3_4)),
                new Line(List.of(p4_1, p4_2, p4_3, p4_4)),
                new Line(List.of(p5_1, p5_2, p5_3, p5_4))
        ));

        Players actual = lines.move(new Players("pobi,honux,crong,jk"));
        Players expected = new Players(List.of(
                new PlayerName("pobi"),
                new PlayerName("jk"),
                new PlayerName("crong"),
                new PlayerName("honux")
        ), new Vertical(5));

        assertThat(actual).isEqualTo(expected);
    }
}