package laddarGame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointTest {

    @DisplayName("point가 true면 해당 자리의 플레이어를 우측으로 이동시킨다.")
    @Test
    void TrueAndRightMove() {
        Point point = Point.of(true);
        Player LG = new Player("LG", 0);
        Player SKT = new Player("SKT", 1);

        point.move(LG, SKT);

        assertEquals(new Position(1), LG.getPosition());
        assertEquals(new Position(0), SKT.getPosition());
    }

    @DisplayName("point가 true면 다음 자리의 플레이어를 좌측으로 이동시킨다.")
    @Test
    void TrueAndLeftMove() {
        Point point = Point.of(false);
        Player LG = new Player("LG", 0);
        Player SKT = new Player("SKT", 1);

        point.move(LG, SKT);

        assertEquals(new Position(0), LG.getPosition());
        assertEquals(new Position(1), SKT.getPosition());

    }
}