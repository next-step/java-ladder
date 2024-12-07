package ladder.domain.ns;

import ladder.domain.interfaces.Line;
import ladder.domain.interfaces.Players;
import ladder.domain.interfaces.Point;
import ladder.exception.PlayersCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static ladder.domain.ns.NsLine.NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE;
import static ladder.domain.ns.NsPlayersTest.POBI_HONUX_CRONG_JK;
import static ladder.domain.wrapper.PlayerNameTest.*;
import static org.assertj.core.api.Assertions.*;

public class NsLineTest {

    @Test
    @DisplayName("라인을 생성한다")
    void create() {
        assertThatNoException().isThrownBy(() -> {
            Point firstPoint = NsPoint.first(true);
            Point next1Point = firstPoint.next(false);
            Point next2Point = next1Point.next(true);
            Point lastPoint = next2Point.last();
            Line line = new NsLine(List.of(firstPoint, next1Point, next2Point, lastPoint));
        });
    }

    @ParameterizedTest(name = "라인생성 오류: 참여자 명수가 0 이하일 경우 오류가 발생한다")
    @ValueSource(ints = {0, -1, Integer.MIN_VALUE})
    void create_참여자명_0_음수_오류(int playersCount) {
        assertThatThrownBy(() -> {
            Line actual = new NsLine(playersCount, () -> true);
        }).isInstanceOf(PlayersCountException.class)
                .hasMessage(NOT_ALLOWED_PLAYER_ZERO_OR_MINUS_MESSAGE);

    }

    @Test
    @DisplayName("포인트들을 조회한다")
    void getPoints() {
        Point firstPoint = NsPoint.first(true);
        Point next1Point = firstPoint.next(false);
        Point next2Point = next1Point.next(true);
        Point lastPoint = next2Point.last();

        List<Point> points = List.of(firstPoint, next1Point, next2Point, lastPoint);
        Line line = new NsLine(points);

        List<Point> actual = line.getPoints();

        assertThat(actual).isEqualTo(points);
    }

    @Test
    @DisplayName("포인트들을 조회한다. 조회한 데이터는 불변이다")
    void getPoints_불변() {
        Point firstPoint = NsPoint.first(true);
        Point next1Point = firstPoint.next(false);
        Point next2Point = next1Point.next(true);
        Point lastPoint = next2Point.last();

        List<Point> points = List.of(firstPoint, next1Point, next2Point, lastPoint);
        Line line = new NsLine(points);
        List<Point> actual = line.getPoints();

        assertThatThrownBy(() -> actual.add(next2Point))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    @DisplayName("한개 라인을 이동한다.")
    void move() {
        Point firstPoint = NsPoint.first(true);
        Point next1Point = firstPoint.next(false);
        Point next2Point = next1Point.next(true);
        Point lastPoint = next2Point.last();
        Line line = new NsLine(List.of(firstPoint, next1Point, next2Point, lastPoint));

        //   p   h   c   j
        // f | t | f | t | f
        //   h   p   j   c
        Players initPlayers = new NsPlayers(POBI_HONUX_CRONG_JK);

        Players actual = line.move(initPlayers);
        Players expected = new NsPlayers(List.of(PLAYER_NAME_HONUX, PLAYER_NAME_POBI, PLAYER_NAME_JK, PLAYER_NAME_CRONG), new NsVertical(1));

        assertThat(actual).isEqualTo(expected);
    }
}