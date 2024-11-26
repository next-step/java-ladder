package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    public static final Players PLAYERS1 = new Players("pobi,crong,honux,jk");

    private Players players;
    private Name playerName1;
    private Name playerName2;
    private Name playerName3;
    private Name playerName4;

    private Point firstPoint;
    private Point next1Point;
    private Point next2Point;
    private Point lastPoint;
    private Line line;

    @BeforeEach
    void setUp() {
        playerName1 = new Name("pobi");
        playerName2 = new Name("crong");
        playerName3 = new Name("honux");
        playerName4 = new Name("jk");

        firstPoint = Point.first(true);
        next1Point = firstPoint.next(false);
        next2Point = next1Point.next(true);
        lastPoint = next2Point.last();

        // f | t | f | t | f
        line = new Line(List.of(firstPoint, next1Point, next2Point, lastPoint));

        players = new Players("pobi,crong,honux,jk");
    }

    @Test
    @DisplayName("플레이어 목록을 생성한다")
    void create() {
        Players expected = new Players(List.of(playerName1, playerName2, playerName3, playerName4));

        assertThat(players).isEqualTo(expected);
    }

    @Test
    @DisplayName("플레이어 목록의 size 를 출력한다")
    void size() {
        int actual = players.size();
        assertThat(actual).isEqualTo(4);
    }

    @Test
    @DisplayName("플레이어 목록의 이름을 출력한다")
    void names() {
        List<Name> actual = players.names();
        List<Name> expected = List.of(
                new Name("pobi"),
                new Name("crong"),
                new Name("honux"),
                new Name("jk")
        );

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void moveLine() {
        //   p   c   h   j
        // f | t | f | t | f
        //   c   p   j   h
        Players actual = players.moveLine(line);
        Players expected = new Players(List.of(
                new Name("crong"),
                new Name("pobi"),
                new Name("jk"),
                new Name("honux")
        ));

        assertThat(actual).isEqualTo(expected);
    }
}