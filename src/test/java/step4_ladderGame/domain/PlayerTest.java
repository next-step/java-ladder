package step4_ladderGame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어가 한칸 앞으로 이동한다.")
    @Test
    void testCase1() {
        Player player = Player.of("LG", 1);

        Player movePlayer = player.move(Position.of(2));

        Assertions.assertThat(movePlayer).isEqualTo(Player.of("LG", 2));
    }

    @DisplayName("플레이어가 한칸 뒤로 이동한다.")
    @Test
    void testCase2() {
        Player player = Player.of("LG", 1);

        Player movePlayer = player.move(Position.of(0));

        Assertions.assertThat(movePlayer).isEqualTo(Player.of("LG", 0));
    }

    @DisplayName("입력받은 플레이어와 포지션을 비교하여 비교값을 반환한다.")
    @Test
    void testCase3() {
        Player player = Player.of("LG", 1);

        int position = player.sorted(Player.of("SKT", 2));

        Assertions.assertThat(position).isEqualTo(-1);
    }
}