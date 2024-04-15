package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayersTest {

    public static final Players PS1 = new Players(List.of(PlayerTest.P1, PlayerTest.P2, PlayerTest.P3));

    @DisplayName("전체 플레이어의 인원을 구한다.")
    @Test
    void test01() {
        assertThat(PS1.totalNumber()).isEqualTo(3);
    }

    @DisplayName("특정 플레이어에 대한 위치를 구한다.")
    @Test
    void test02() {
        Position position = PS1.getPosition(PlayerTest.P1);
        assertThat(position).isEqualTo(new Position(0, 0));
    }

    @DisplayName("순서를 입력받아 플레이어를 구한다.")
    @Test
    void test03() {
        Player player = PS1.findByOrder(0);
        assertThat(player).isEqualTo(PlayerTest.P1);
    }

    @DisplayName("특정 플레이어의 순서를 구한다.")
    @Test
    void test04() {
        int order = PS1.getOrder(PlayerTest.P1);
        assertThat(order).isEqualTo(0);
    }
}
