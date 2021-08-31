package nextstep.ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderInfoTest {

    @DisplayName("사다리 가로 세로 길이를 받는 정보 클래스")
    @Test
    void create() {
        assertThat(new LadderInfo(1,2))
                .isEqualTo(new LadderInfo(1,2));
    }
}