package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest {

    @Test
    void create() {
        Player player1 = new Player("HI");
        assertThat(player1.getName()).isEqualTo("HI");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Player player2 = new Player("HEELLO");
        }).withMessageMatching("사람에 이름을 최대5글자까지 가능합니다.");
    }

}
