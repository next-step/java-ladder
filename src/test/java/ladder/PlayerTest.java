package ladder;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
    @Test
    public void 양쪽단절상태포인트_지나가기() {
        // given
        Point point = Point.neitherLinkedPoint;
        Player player = new Player(4, "이름");
        // when
        player.movePoint(point);
        // then
        assertThat(player.getDestination()).isEqualTo(4);
    }

    @Test
    public void 오른쪽연결상태포인트_지나가기() {
        // given
        Point point = Point.onlyRightLinkedPoint;
        Player player = new Player(4, "이름");
        // when
        player.movePoint(point);
        // then
        assertThat(player.getDestination()).isEqualTo(5);
    }

    @Test
    public void 왼쪽연결상태포인트_지나가기() {
        // given
        Point point = Point.onlyLeftLinkedPoint;
        Player player = new Player(4, "이름");
        // when
        player.movePoint(point);
        // then
        assertThat(player.getDestination()).isEqualTo(3);
    }
}
