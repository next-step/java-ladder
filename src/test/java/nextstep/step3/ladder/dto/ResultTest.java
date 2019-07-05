package nextstep.step3.ladder.dto;

import nextstep.step3.ladder.domain.*;
import nextstep.step3.ladder.util.StringUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-07-03 17:58
 */
class ResultTest {
    @DisplayName("전달받은 Index를 통해 endIndex를 가지고 오")
    @Test
    void findPrize() {
        Ladder ladder = new Ladder(
                Arrays.asList(
                        new LadderLine(
                                Arrays.asList(
                                        new Link(0, true, false),
                                        new Link(1, false, true),
                                        new Link(2, false, false))),
                        new LadderLine(
                                Arrays.asList(
                                        new Link(0, false, false),
                                        new Link(1, false, false),
                                        new Link(2, false, false)))));
        Map<Integer, Integer> playResult = LadderFactory.play(ladder, 3);

        Result result = new Result(playResult);
        assertThat(result.findPrize(1)).isEqualTo(0);
    }
}