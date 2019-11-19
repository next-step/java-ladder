package ladder.domain.result;

import ladder.domain.player.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static ladder.TestHelper.getDestinationHelper;
import static ladder.TestHelper.getPlayerHelper;
import static org.assertj.core.api.Assertions.assertThat;

class ResultPointsTest {

    @Test
    void makeResults() {
        ResultPoints resultPoints = new ResultPoints(Collections.singletonList(new ResultPoint(1, 3)));
        Player player = getPlayerHelper("chan", 1);
        Destination destination = getDestinationHelper(3, 5, "1000");

        Result result = new Result(player, destination);

        Results results = resultPoints.makeResults(Arrays.asList(player), Arrays.asList(destination));

        assertThat(results.getResults()).contains(result);
    }
}