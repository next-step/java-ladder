package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    @DisplayName("이름으로 플레이어를 생성한다")
    @Test
    void playerCreateTest() {
        Player player = new Player("panda");
        assertThat(player.getName()).isEqualTo("panda");
    }

    @DisplayName("이름은 1글자 이상, 5글자 이하다. 이외의 경우 예외를 발생시킨다")
    @Test
    void playerCreateExceptionTest() {
        assertThatThrownBy(()->new Player("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->new Player("pandahun")).isInstanceOf(IllegalArgumentException.class);
    }
}
