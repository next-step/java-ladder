package nextstep.step2.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-30 04:18
 */
public class LadderTest {
    @DisplayName("사다리 생성 상태 확인")
    @Test
    void createLadderStatus() {
        Ladder ladder = new Ladder(5, 5);
        List<String> printStatus = ladder.stream()
                .map(ladderLine -> ladderLine.toString())
                .collect(Collectors.toList());

        for (int i = 0; i < printStatus.size(); i++) {
            System.out.println(printStatus.get(i));
        }

    }
}
