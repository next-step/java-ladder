package ladder.domain.player;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderPlayerTest {

    @Test
    void LinesPlyerCreateTest() {
        LadderPlayer pobi = LadderPlayer.create("pobi");
        assertThat(pobi.getPlayerName()).isEqualTo("pobi");
    }

    @Test
    void LinesPlayerCreate_5글자이상_Test() {
        assertThatThrownBy(() -> LadderPlayer.create("pobiccc"))
                .hasMessageMatching("사람 이름은 최대 5글자 입니다.");
    }
}
