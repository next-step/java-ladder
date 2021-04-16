package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import nextstep.ladder.domain.Player;
import nextstep.ladder.domain.Point;
import nextstep.ladder.domain.Prize;
import nextstep.ladder.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PrizeTest {
    @Test
    @DisplayName("플레이어 위치에 따라 상을 출력하도록 한다.")
    void prizeMappingTestByPlayerPosition() {
        Prizes prizes = new Prizes(Arrays.asList("꽝", "5000", "꽝", "3000"));

        Prize prize = prizes.givePrizeTo(new Player("pobi", new Point(0)));

        assertThat(prize).isEqualTo(new Prize("꽝"));
    }
}
