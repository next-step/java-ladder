package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class PlayerTest {
    @Test
    @DisplayName("유효하지 않은 이름으로 Player 생성 시 예외가 발생한다")
    void createPlayerWithNullName() {
        assertThatThrownBy(() -> Player.from(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("동일한 이름의 Player는 equals 비교 시 동일하다")
    void playerEquality() {
        Player player1 = Player.from("honux");
        Player player2 = Player.from("honux");

        assertThat(player1).isEqualTo(player2);
    }
}
