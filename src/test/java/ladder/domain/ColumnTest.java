package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ColumnTest {
    @Test
    @DisplayName("왼쪽이 이동 가능한 경우 위치 값이 1 증가한다.")
    public void can_move_left(){
        Player player = Player.of("A", 1);
        Column.of(true, false).navigate(player);
        Assertions.assertThat(player.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("오른쪽이 이동 가능한 경우 위치 값이 1 증가한다.")
    public void can_move_right(){
        Player player = Player.of("A", 0);
        Column.of(false, true).navigate(player);
        Assertions.assertThat(player.position()).isEqualTo(1);
    }
}
