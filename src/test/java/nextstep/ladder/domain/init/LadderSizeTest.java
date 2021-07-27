package nextstep.ladder.domain.init;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("사다리의 크기를 정하는 초기화 정보")
class LadderSizeTest {

    @DisplayName("사다리 크기는 너비와 높이로 이루어진다")
    @Test
    void init() {
        assertThat(LadderSize.of(1, 2)).isInstanceOf(LadderSize.class);
    }
}
