package ladder.domain.result;

import ladder.domain.player.Player;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static ladder.TestHelper.getDestinationHelper;
import static ladder.TestHelper.getPlayerHelper;
import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {

    @Test
    void 이름을입력받으면_해당_실행결과_반환하기() {
        String chanName = "chan";
        String inName = "in";
        Player chan = getPlayerHelper(chanName, 0);
        Player in = getPlayerHelper(inName, 1);

        String chanRewardValue = "100";
        String inRewardValue = "999";
        Destination chanDestination = getDestinationHelper(0, 1, chanRewardValue);
        Destination inDestination = getDestinationHelper(1, 1, inRewardValue);

        Result chanResult = new Result(chan, chanDestination);
        Result inResult = new Result(in, inDestination);
        Results results = new Results(Arrays.asList(chanResult, inResult));

        Result findChanResult = results.findByName(chanName);
        Result findInResult = results.findByName(inName);

        assertThat(findChanResult).isEqualTo(chanResult);
        assertThat(findInResult).isEqualTo(inResult);

    }
}