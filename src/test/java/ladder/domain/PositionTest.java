package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {
    private Line line;
    private Point first;
    private Point second;
    private Point third;
    private Point fourth;
    private Point fifth;
    private Point last;

    @BeforeEach
    void setUp() {
        first = Point.first(true);
        second = first.next(false);
        third = second.next(true);
        fourth = third.next(false);
        fifth = fourth.next(false);
        last = fifth.last();
        // f | t | f | t | f | f | f
        //  fir sec thr fou fif las
        line = new Line(List.of(first, second, third, fourth, fifth, last));
    }

    @Test
    @DisplayName("생성")
    void create() {
        Position position = new Position(new X(0), new Y(0));
        Position expected1 = new Position();
        Position expected2 = new Position(0, 0);

        assertThat(position).isEqualTo(expected1);
        assertThat(position).isEqualTo(expected2);
    }

    @Test
    @DisplayName("이동_성공_좌측아래")
    void move_성공_좌측아래() {
        //   0   1   2   3   4   5
        // f | t | f | t | f | f | f
        //  fir sec thr fou fif las
        Position position = new Position(4, 0);

        Position actual = position.move(fourth);
        Position expected = new Position(3, 1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동_성공_우측아래")
    void move_성공_우측아래() {
        //   0   1   2   3   4   5
        // f | t | f | t | f | f | f
        //  fir sec thr fou fif las
        Position position = new Position(2, 0);

        Position actual = position.move(third);
        Position expected = new Position(3, 1);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("이동_성공_아래")
    void move_성공_아래() {
        //   0   1   2   3   4   5
        // f | t | f | t | f | f | f
        //  fir sec thr fou fif las
        Position position = new Position(4, 0);

        Position actual = position.move(fifth);
        Position expected = new Position(4, 1);

        assertThat(actual).isEqualTo(expected);
    }
}