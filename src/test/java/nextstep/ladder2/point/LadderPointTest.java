package nextstep.ladder2.point;

import nextstep.ladder2.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderPointTest {

    @Test
    @DisplayName("생성 테스트")
    void create() {
        Point playerPoint = new Point(5, 10);
        LadderPoint ladderPoint = new LadderPoint(playerPoint);

        assertThat(ladderPoint.left().index()).isEqualTo(4);
        assertThat(ladderPoint.right().index()).isEqualTo(5);
    }

    @Test
    @DisplayName("사이드값 포인트 확인 (0 왼쪽값)")
    void checkMinTest() {
        Point playerPoint = new Point(0, 10);
        LadderPoint ladderPoint = new LadderPoint(playerPoint);

        assertThat(ladderPoint.left().index()).isEqualTo(Point.INVALID_POINT.index());
    }

    @Test
    @DisplayName("사이드값 포인트 확인 (0 오른쪽)")
    void checkMaxTest() {
        Point playerPoint = new Point(10, 11);
        LadderPoint ladderPoint = new LadderPoint(playerPoint);

        assertThat(ladderPoint.right().index()).isEqualTo(Point.INVALID_POINT.index());
    }

}