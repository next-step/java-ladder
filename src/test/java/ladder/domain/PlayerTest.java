package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class PlayerTest {

    @Test
    void 참가자생성() {
        Player player1 = new Player("홍길동");
        Player player2 = new Player("홍길동친구");
        assertAll(
                () -> assertThat(player1.getName()).isEqualTo("홍길동"),
                () -> assertThat(player2.getName()).isEqualTo("홍길동친구")
        );
    }

    @Test
    void 참가자_이름글자수_초과() {
        assertThatThrownBy(() -> new Player("김수한무거북이")).isInstanceOf(IllegalArgumentException.class);
    }
}