package nextstep.step2.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-ladder
 * create date  : 2019-06-29 03:22
 */
public class LadderLineTest {
    @DisplayName("사다리 Line 생성된 상태 확인")
    @Test
    void createLadderLineStatue() {
        LadderLine line = new LadderLine(10);
        line.stream()
                .forEach(System.out::println);
    }
}