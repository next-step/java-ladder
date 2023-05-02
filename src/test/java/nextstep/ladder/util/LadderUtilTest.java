package nextstep.ladder.util;

import nextstep.ladder.domain.util.LadderUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderUtilTest {
    @Test
    @DisplayName("라인만들기 테스트")
    void makeLadderLine() {
        assertThat(LadderUtil.makeLadderLine(3))
                .hasSize(3);
    }

    @Test
    @DisplayName("참가자가 1명일때 라인만들기")
    void makeLadderLineAtOne() {
        assertThat(LadderUtil.makeLadderLine(1))
                .hasSize(1);
    }
}
