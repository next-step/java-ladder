package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderLineTest {

    @DisplayName("Line은 참가자의 수만큼 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void create(int userCount) {
        assertThat(LadderLine.of(userCount).getLinkCount()).isEqualTo(userCount);
    }

    @DisplayName("Line의 Link가 연결되어있는지 확인")
    @Test
    void checkLinkConnect() {
        LadderLine ladderLine = LadderLine.of(Arrays.asList(
                LadderLink.DIS_CONNECT,
                LadderLink.CONNECT,
                LadderLink.DIS_CONNECT));

        assertThat(ladderLine.isLinkConnect(0)).isFalse();
        assertThat(ladderLine.isLinkConnect(1)).isTrue();
        assertThat(ladderLine.isLinkConnect(2)).isFalse();
    }
}
