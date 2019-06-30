package nextstep.step2.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("사다리 Line 생성된 상태 확인 - 마지막 index는 무조건 false")
    @Test
    void createLadderLineStatue() {
        LadderLine line = new LadderLine(2);
        List<Boolean> convertLine = line.stream()
                .map(Link::status)
                .collect(Collectors.toList());
        int lastIndex = convertLine.size() -1;
        assertThat(convertLine.get(lastIndex)).isFalse();
    }
}