package nextstep.step2.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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
    @DisplayName("사다리 생성 상태 확인 - 사다리 높이")
    @Test
    void createLadderStatus() {
        Ladder ladder = new Ladder(5, 5);
        List<String> printStatus = ladder.stream()
                .map(ladderLine -> ladderLine.toString())
                .collect(Collectors.toList());

        assertThat(printStatus.size()).isEqualTo(5);
    }

    @DisplayName("사다리를 생성할때 예외상황 - 높이")
    @Test
    void createLadder() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Ladder ladder = new Ladder(1, 2);
        }).withMessageContaining("사다리의 높이는 3, 길이는 2이상만 가능합니다.");
    }
}
