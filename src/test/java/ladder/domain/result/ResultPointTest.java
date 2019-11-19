package ladder.domain.result;

import ladder.domain.common.Point;
import ladder.domain.player.Name;
import ladder.domain.player.Player;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class ResultPointTest {

    @Test
    void makeResult() {
        Player player = new Player(new Name("chan"), new Point(0, 0));
        Destination destination = new Destination(new Prize("100"), new Point(3, 5));

        ResultPoint resultPoint = new ResultPoint(0, 3);
        Result result = resultPoint.makeResult(Collections.singletonList(player), Collections.singletonList(destination));

        assertThat(result.getPlayerName()).isEqualTo(player.getName());
        assertThat(result.getReward()).isEqualTo(destination.getReward());
    }


}